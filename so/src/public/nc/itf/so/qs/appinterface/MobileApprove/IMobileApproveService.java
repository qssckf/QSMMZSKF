package nc.itf.so.qs.appinterface.MobileApprove;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.data.IRowSet;

public interface IMobileApproveService {
	
	public abstract List<Map<String, Object>> getPFTaskList(String pk_group, String userid, String date, String statuskey, String statuscode, String cond,int startline, int count,int pagenum) throws BusinessException;
	
	public abstract Map<String, Object> getTaskBill(String groupid, String userid, String taskid, String statuskey, String statuscode) throws BusinessException;
	
	public abstract Map<String, Object> getUserInfo(String usercode, String date) throws Exception;
		  
	public abstract Map<String, Object> getApprovedDetail(String groupid, String userid, String taskid, String statuskey, String statuscode, int startline, int count) throws Exception;
	
	public Map<String, Object> getUserList(String groupid, String userid, String taskid, int startline, int count, String condition) throws BusinessException;
	
	public Map<String, Object> doAgree(String groupid, String userid, String taskid, String note, String cuserids) throws BusinessException;
	
	public Map<String, Object> getAssignPsnList(String groupid, String userid, String taskid, String isagree, int startline, int count, String condition) throws Exception;
	
	public Map<String, Object> doDisAgree(String groupid, String userid, String taskid, String note, String cuserids) throws BusinessException;
	
	public abstract Map<String, Object> doReject(String groupid, String userid, String taskid, String note, String nodeid) throws BusinessException;
	
	public abstract Map<String, Object> getRejectNodeList(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4) throws Exception;
	
	public List<Map<String, Object>> getRefDataList(String pk_group,String cond,String voclass,String entityname,String field,int startline, int count,int pagenum) throws BusinessException;
	
}
