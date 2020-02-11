package com.mi.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author : Rong
 * @date : 2020/2/11
 * @Desc:
 */


@Data
@Table(name = "customer_info")
public class Customer {

    @Id
    @KeySql(useGeneratedKeys = true) //回显
    private String customerId;

    private String customerName;

    private String customerPwd;


}