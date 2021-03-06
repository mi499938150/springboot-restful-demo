package com.mi.util;

import com.mi.Vo.ResultVo;
/**
 * @author : Rong
 * @date : 2019/12/3
 * @Desc: 封装参数显示
 */

public class ResultVoUtil {
    public static ResultVo success(Object object){
        ResultVo resultVo = new ResultVo();
        resultVo.setData(object);
        resultVo.setCode(200);
        resultVo.setMsg("成功");
        return resultVo;
    }

    public static ResultVo success(){
        return success(null);
    }

    public static ResultVo error(Integer code, String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }
}