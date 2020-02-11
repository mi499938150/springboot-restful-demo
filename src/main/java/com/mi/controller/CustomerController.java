package com.mi.controller;

import com.mi.Vo.ResultVo;
import com.mi.domain.Customer;
import com.mi.mapper.CustomerMapper;
import com.mi.util.ResultVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Rong
 * @date : 2020/2/11
 * @Desc:
 */


@RestController
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 查询多个客户
     * @return
     */
    @GetMapping(value = "/customers")
    public ResultVo<Customer> findCustomerList(){

        List<Customer> customers = customerMapper.selectAll();
        return ResultVoUtil.success(customers);
    }

    /**
     * 查询一个客户
     * @param id
     * @return
     */
    @GetMapping(value = "/customer/{id}")
    public ResultVo findByOneCustomer(@PathVariable("id")Integer id){
        Customer customer = customerMapper.selectByPrimaryKey(id);
        return ResultVoUtil.success(customer);
    }

    /**
     * 添加客户
     * @param customerName
     * @param customerPwd
     * @return
     */
    @PostMapping(value = "/customer")
    public ResultVo addCustomer(@RequestParam("customerName")String customerName,
                                @RequestParam("customerPwd")String customerPwd){
        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        customer.setCustomerPwd(customerPwd);
        return ResultVoUtil.success();
    }

    /**
     * 删除客户
     * @param id
     * @return
     */
    @DeleteMapping(value = "/customer/{id}")
    public ResultVo deleteCustomer(@PathVariable("id")Integer id){
        customerMapper.deleteByPrimaryKey(id);
        return ResultVoUtil.success();
    }

    /**
     * 更新客户
     * @param id
     * @param customer
     * @return
     */
    @PutMapping(value = "/customer/{id}")
    public ResultVo updateCustomer(@PathVariable("id")Integer id,
                                     Customer customer){
        Customer c = customerMapper.selectByPrimaryKey(id);
        c.setCustomerName(customer.getCustomerName());
        c.setCustomerPwd(customer.getCustomerPwd());
        customerMapper.updateByPrimaryKey(c);
        return ResultVoUtil.success();
    }
}