package base.controller.pack;

import base.model.response.MessageWrapper;
import base.model.response.ResponseWrapper;
import base.model.response.ResultWrapper;
import base.model.response.StatusCode;
import java.util.List;
import java.util.Map;

/**
 * @author long
 * @since 18-3-4
 */
public class ResponsePacker {

  public ResponseWrapper pack(Map<String,Object> paras,DataRequest task){
    List<?> result;
    try{
      result=task.execute(paras);
    }catch(Exception e){

      //TODO handle exception
      return new MessageWrapper(StatusCode.ERROR,paras,e.getMessage());
    }
    //TODO handle successful request
    return new ResultWrapper(StatusCode.SUCCESS,paras,result);
  }

}
