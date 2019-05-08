package com.insightchain.dao.domain;

import com.insightchain.common.domain.BasicDomain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
*
* @description
* @time 2019/5/8 16:10
* @author tianxiang@insightchain.io
*
*/
@Data
@Entity
@Table(name = "u_user")
public class User extends BasicDomain {

	private static final long serialVersionUID = 45435341654645L;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String userName;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String nickName;

    /**
     *
     */
    private String headImageUrl;

    /**
     * 用户认证级别：1普通用户 2kyc用户  6panel用户和kyc用户
     */
    private Integer certificationType;

    /**
     *
     */
    private String phoneNumber;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private Integer emailVerified;

    /**
     *
     */
    private String invitationCode;

    /**
     *
     */
    private Long invitedByUserId;

    /**
     *
     */
    private Timestamp registerTime;

    /**
     *
     */
    private String ethWalletAddress;

    /**
     *
     */
    private String btcWalletAddress;

    /**
     *
     */
    private String neoWalletAddress;

    /**
     *
     */
    private String eosWalletAddress;

    /**
     *
     */
    private Long ethExchangeAddressId;

    /**
     *
     */
    private Long btcExchangeAddressId;

    /**
     *
     */
    private Long neoExchangeAddressId;

    /**
     *
     */
    private Long eosExchangeAddressId;

    /**
     *
     */
    private Double inbNumber;
    
    /**
     *
     */
    private String activationCode ;

    /**
     *
     */
    private Integer invitationCodeNumber;

    /**
     *
     */
    private Integer emailSendStatus;
    
    /**
     *
     */
    private Double inviteReward;

    /**
     *
     */
    private Integer gender;

    /**
     *
     */
    private Timestamp birthday;

    /**
     *  用户状态：1正常用户 2禁言用户 3下线用户
     */
    private Integer status; //

    /**
     *  用户类型：0正常用户 1 超级管理员 2管理员
     */
    private Integer adminLevel;

    /**
     *
     */
    private Integer refusePanelType;

    /**
     *
     */
    private Double inbpNumber;

    /**
     *
     */
    private Double inbpFrozenNumber;

    /**
     *
     */
    private Double inbFrozenNumber;

    /**
     *
     */
    private Double dailyBonusInbNumber;

    /**
     * 是否是kyc用户
     */
    private Boolean kyc;

    /**
     * 是否是panel用户
     */
    private Boolean panel;

    /**
     *  活跃时间差，距离现在
     */
    private Integer timeDiff;

    /**
     *  邀请kyc的奖励
     */
    private Double totalInbpKycReward;

    /**
     *  邀请kyc人数
     */
    private Integer kycRewardNumber;

    /**
     *  用户发送接收红包状态 0不能接收不能发送，1能接收不能发送，2不能接收能发送，3能接收能发送
     */
    private Integer bounsStatus; //

    /**
     *  微信第三方登录
     */
    private String wechatUnionId;

    /**
     *
     */
    private Integer userType;

    /**
     *
     */
    private Integer fromType;

    /**
     *  邀请好友额外奖励比例
     */
    private Double invitationRewardRatio;

    /**
     * 邀请好友额外奖励有效天数
     */
    private Integer validDays;

}