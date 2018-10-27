package com.fzy.controller;

import com.fzy.entity.MajorProduct;
import com.fzy.entity.vo.ResultVo;
import com.fzy.service.MajorProductService;
import com.fzy.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: MajorProductController
 * @description:
 * @author: fzy
 * @date: 2018-10-25 19:33
 **/
@RestController
@RequestMapping("/buyer/majorProduct")
@Api(tags="热门推荐")
@Slf4j
public class MajorProductController {

    @Autowired
    private MajorProductService majorProductService;

    @GetMapping("/findAllList")
    @ApiOperation("查询热门推荐列表")
    public ResultVo findAllList(){
        try {
            List<MajorProduct> list = majorProductService.findAll();
            return ResultVOUtil.success(list);
        } catch (Exception e) {
            log.error("查询热门推荐列表失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "查询热门推荐列表失败");
        }
    }

    @GetMapping("/save")
    @ApiOperation("添加热门推荐列表")
    public ResultVo save(@RequestParam String productId){
        try {
            if(majorProductService.save(productId)>0){
                return ResultVOUtil.success("添加热门列表成功");
            }
            return  ResultVOUtil.error(1001, "添加热门推荐列表失败");
        } catch (Exception e) {
            log.error("添加热门推荐列表失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "添加热门推荐列表失败");
        }
    }

    @GetMapping("/delete")
    @ApiOperation("删除热门推荐列表")
    public ResultVo delete(@RequestParam String majorId){
        try {
            if(majorProductService.delete(majorId)>0){
                return ResultVOUtil.success("删除热门推荐列表成功");
            }
            return  ResultVOUtil.error(1001, "删除热门推荐列表失败");
        } catch (Exception e) {
            log.error("删除热门推荐列表失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "删除热门推荐列表失败");
        }
    }
}
