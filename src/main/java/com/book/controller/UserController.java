package com.book.controller;

import com.book.entity.ProductInfo;
import com.book.service.SourceTableService;
import com.book.view.RequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 一点点
 * @Date: 2018/12/3 23:29
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    SourceTableService sourceTableService;

    @GetMapping("/findList")
    public List<ProductInfo> getProductInfoList(){
        return sourceTableService.findList();
    }

    @PostMapping("/update")
    public String updateTableColumnToCopy(@RequestBody RequestVO vo){
        sourceTableService.updateTableColumnToCopy(vo);
        return "success";
    }

    @PostMapping("/update2")
    public String updateTableNameToCopy(@RequestBody RequestVO vo){
        sourceTableService.updateTableNameToCopy(vo);
        return "success";
    }

    @PostMapping("/create")
    public String createTable(@RequestBody RequestVO vo){
        sourceTableService.createTableCopy(vo);
        return "success";
    }

}
