/*
 * Copyright 2022 Holoinsight Project Authors. Licensed under Apache-2.0.
 */
package io.holoinsight.server.home.biz.service.impl;

import io.holoinsight.server.common.DateUtil;
import io.holoinsight.server.common.J;
import io.holoinsight.server.home.biz.service.AlarmHistoryDetailService;
import io.holoinsight.server.home.common.util.StringUtil;
import io.holoinsight.server.home.dal.converter.AlarmHistoryDetailConverter;
import io.holoinsight.server.home.dal.mapper.AlarmHistoryDetailMapper;
import io.holoinsight.server.home.dal.model.AlarmHistoryDetail;
import io.holoinsight.server.home.facade.AlarmHistoryDetailDTO;
import io.holoinsight.server.home.facade.page.MonitorPageRequest;
import io.holoinsight.server.home.facade.page.MonitorPageResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
@Slf4j
public class AlarmHistoryDetailServiceImpl extends
    ServiceImpl<AlarmHistoryDetailMapper, AlarmHistoryDetail> implements AlarmHistoryDetailService {

  @Resource
  private AlarmHistoryDetailConverter alarmHistoryDetailConverter;

  @Override
  public MonitorPageResult<AlarmHistoryDetailDTO> getListByPage(
      MonitorPageRequest<AlarmHistoryDetailDTO> pageRequest) {
    if (pageRequest.getTarget() == null) {
      return null;
    }

    QueryWrapper<AlarmHistoryDetail> wrapper = new QueryWrapper<>();

    AlarmHistoryDetail alarmHistoryDetail =
        alarmHistoryDetailConverter.dtoToDO(pageRequest.getTarget());

    if (null != alarmHistoryDetail.getHistoryId()) {
      wrapper.eq("history_id", alarmHistoryDetail.getHistoryId());
    }

    if (null != alarmHistoryDetail.getAlarmTime()) {
      wrapper.eq("alarm_time", alarmHistoryDetail.getAlarmTime());
    }

    if (null != alarmHistoryDetail.getTenant()) {
      wrapper.eq("tenant", alarmHistoryDetail.getTenant());
    }

    if (StringUtils.isNotBlank(alarmHistoryDetail.getWorkspace())) {
      wrapper.eq("workspace", alarmHistoryDetail.getWorkspace());
    }

    if (null != pageRequest.getFrom()) {
      wrapper.ge("alarm_time", new Date(pageRequest.getFrom()));
    }

    if (null != pageRequest.getTo()) {
      wrapper.le("alarm_time", new Date(pageRequest.getTo()));
    }

    if (null != alarmHistoryDetail.getEnvType()) {
      wrapper.eq("env_type", alarmHistoryDetail.getEnvType());
    }

    if (StringUtil.isNotBlank(pageRequest.getSortBy())
        && StringUtil.isNotBlank(pageRequest.getSortRule())) {
      if (pageRequest.getSortRule().toLowerCase(Locale.ROOT).equals("desc")) {
        wrapper.orderByDesc(pageRequest.getSortBy());
      } else {
        wrapper.orderByAsc(pageRequest.getSortBy());
      }
    } else {
      wrapper.orderByDesc("id");
    }

    Page<AlarmHistoryDetail> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());

    page = page(page, wrapper);

    MonitorPageResult<AlarmHistoryDetailDTO> AlarmHistoryDetails = new MonitorPageResult<>();

    AlarmHistoryDetails.setItems(alarmHistoryDetailConverter.dosToDTOs(page.getRecords()));
    AlarmHistoryDetails.setPageNum(pageRequest.getPageNum());
    AlarmHistoryDetails.setPageSize(pageRequest.getPageSize());
    AlarmHistoryDetails.setTotalCount(page.getTotal());
    AlarmHistoryDetails.setTotalPage(page.getPages());

    return AlarmHistoryDetails;
  }

  @Override
  public List<Map<String, Object>> count(MonitorPageRequest<AlarmHistoryDetailDTO> pageRequest) {
    AlarmHistoryDetailDTO target = pageRequest.getTarget();
    QueryWrapper<AlarmHistoryDetail> queryWrapper = new QueryWrapper<>();
    queryWrapper.select("count(1) as c", "alarm_time");
    queryWrapper.groupBy("alarm_time");
    queryWrapper.orderByDesc("alarm_time");
    queryWrapper.last("limit 600");

    if (StringUtils.isNotBlank(target.getUniqueId())) {
      queryWrapper.eq("unique_id", target.getUniqueId());
    }
    if (StringUtils.isNotBlank(target.getTenant())) {
      queryWrapper.eq("tenant", target.getTenant());
    }
    if (StringUtils.isNotBlank(target.getWorkspace())) {
      queryWrapper.eq("workspace", target.getWorkspace());
    }
    queryWrapper.between("gmt_create",
        DateUtil.getDateOf_YYMMDD_HHMMSS(new Date(pageRequest.getFrom())),
        DateUtil.getDateOf_YYMMDD_HHMMSS(new Date(pageRequest.getTo())));

    String sql = queryWrapper.getSqlSegment();
    log.info("sql :{} {}", sql, J.toJson(queryWrapper.getParamNameValuePairs()));
    List<Map<String, Object>> list = listMaps(queryWrapper);

    return list;
  }
}
