package com.insightchain.dao.domain;

import com.insightchain.common.domain.BasicDomain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "a_account_flows")
public class AccountFlows extends BasicDomain {

  /**
   * 时间
   */
  private Timestamp time;

  /**
   * 订单id
   */
  private Long orderId;

  /**
   *
   */
  private Long fromUserId;

  /**
   *
   */
  private Long toUserId;

  /**
   * 货币数量
   */
  private Double coinNumber;

  /**
   * 类型
   */
  private Integer type;

  /**
   * 系统标志
   */
  private String symbol;

}
