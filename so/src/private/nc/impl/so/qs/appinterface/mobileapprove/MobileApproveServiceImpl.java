package nc.impl.so.qs.appinterface.mobileapprove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import nc.bs.framework.common.InvocationInfoProxy;
import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.bs.pub.pf.PfUtilTools;
import nc.bs.wfengine.engine.ActivityInstance;
import nc.impl.pubapp.pattern.database.DataAccessUtils;
import nc.itf.so.qs.appinterface.MobileApprove.IMobileApproveService;
import nc.itf.uap.pf.IWorkflowDefine;
import nc.itf.uap.pf.IWorkflowMachine;
import nc.itf.uap.pf.IplatFormEntry;
import nc.ui.pf.multilang.PfMultiLangUtil;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.pf.mobileapp.ITaskType;
import nc.vo.pf.mobileapp.MobileAppUtil;
import nc.vo.pf.mobileapp.TaskMetaData;
import nc.vo.pf.mobileapp.query.TaskQuery;
import nc.vo.pf.mobileapp.query.UserMatcher;
import nc.vo.pf.mobileapp.query.UserQuery;
import nc.vo.pf.pub.util.ArrayUtil;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.pf.AssignableInfo;
import nc.vo.pub.pf.Pfi18nTools;
import nc.vo.pub.workflownote.WorkflownoteVO;
import nc.vo.pubapp.pattern.data.IRowSet;
import nc.vo.sm.UserVO;
import nc.vo.so.qs.appinterface.query.AbstractRefDataQuery;
import nc.vo.so.qs.appinterface.query.ExApproveDetailQuery;
import nc.vo.so.qs.appinterface.query.PaginationQueryFacade;
import nc.vo.so.qs.appinterface.util.ExMobileAppUtil;
import nc.vo.uap.pf.OrganizeUnit;
import nc.vo.uap.wfmonitor.ProcessRouteRes;
import nc.vo.wfengine.core.activity.Activity;
import nc.vo.wfengine.core.activity.GenericActivityEx;
import nc.vo.wfengine.core.activity.SubFlow;
import nc.vo.wfengine.core.parser.UfXPDLParser;
import nc.vo.wfengine.core.participant.Participant;
import nc.vo.wfengine.core.workflow.WorkflowProcess;
import nc.vo.wfengine.definition.WorkflowTypeEnum;
import nc.vo.wfengine.pub.WfTaskOrInstanceStatus;
import nc.vo.wfengine.pub.WfTaskType;

public class MobileApproveServiceImpl implements IMobileApproveService {

	private DataAccessUtils dao;
	
	public DataAccessUtils getDao() {
    	
    	if(dao==null){
    		dao=new DataAccessUtils();
    	}
		return dao;
	}
	
	
	@Override
	public List<Map<String, Object>> getPFTaskList(String pk_group,String userid, String date, String statuskey, String statuscode,String cond, int startline, int count, int pagenum) throws BusinessException {
		// TODO 自动生成的方法存根
		
		ITaskType taskType = ExMobileAppUtil.getTaskType(statuskey, statuscode);
		TaskQuery query = taskType.createNewTaskQuery();
		
		query.setPk_group(pk_group);
		query.setCuserid(userid);
		query.setDate(date);
		query.setTaskType(taskType);

		
		List<Map<String, Object>> list = PaginationQueryFacade.getInstance().query(query,startline,count,pagenum);
		
		return list;
	}

	@Override
	public Map<String, Object> getTaskBill(String groupid, String userid,String taskid, String statuskey, String statuscode) throws BusinessException {
		// TODO 自动生成的方法存根
		
		ITaskType taskType = ExMobileAppUtil.getTaskType(statuskey, statuscode);
		TaskQuery query = taskType.createNewTaskQuery();
		
		if(InvocationInfoProxy.getInstance().getGroupId()==null){
			InvocationInfoProxy.getInstance().setGroupId(groupid);
		}
     
 
		Object obj = query.queryTaskBill(taskid);
     
		TaskMetaData tmd = query.queryTaskMetaData(taskid);
     
		String pk_billtype = tmd.getBillType();
		String billTypeName = Pfi18nTools.i18nBilltypeName(pk_billtype);
     
		Map<String, Object> map = ExMobileAppUtil.createHashMap();
		map.put("taskbill", obj);
		map.put("billtypename", billTypeName);
     
		return map;
		

	}

	@Override
	public Map<String, Object> getUserInfo(String usercode, String date) throws Exception {
		// TODO 自动生成的方法存根
		
		Map<String, Object> retobj=new HashMap();
		
		String sql="select us.pk_group,us.cuserid,us.user_code,us.user_name,us.pk_base_doc,job.pk_hrorg,dept.pk_dept,dept.name from sm_user us left join hi_psnjob job on us.pk_base_doc=job.pk_psndoc and job.ismainjob='Y' and job.poststat='Y' left join org_dept dept on job.pk_dept=dept.pk_dept where us.user_code='"+usercode+"' and us.abledate<='"+date+"'";
		
		IRowSet rs=this.getDao().query(sql);
		
		JSONArray jsonarry=new JSONArray();
		
		if(rs.next()){
			
			JSONObject json1=new JSONObject();
			
			json1.put("pk_group", rs.getString(0));
			json1.put("userid", rs.getString(1));
			json1.put("user_code", rs.getString(2));
			json1.put("user_name", rs.getString(3));
			if(rs.getString(4)!=null){
				json1.put("pk_psndoc", rs.getString(4));
			}
			if(rs.getString(5)!=null){
				json1.put("pk_org", rs.getString(5));
			}
			if(rs.getString(6)!=null){
				json1.put("pk_dept", rs.getString(6));
			}
			if(rs.getString(7)!=null){
				json1.put("deptname", rs.getString(7));
			}
			
			retobj.put("psninfo", json1);
			
			String user=rs.getString(1);
			
			sql="select func.funcode,func.fun_name from sm_user_role ur inner join sm_perm_func pfunc on ur.pk_role=pfunc.subjectid inner join (select pk_responsibility,busi_pk from sm_resp_func group by pk_responsibility,busi_pk) rfunc on pfunc.ruleid=rfunc.pk_responsibility inner join sm_funcregister func on rfunc.busi_pk=func.funcode where func.funcode like '%400630%' and cuserid='"+user+"'";
			
			IRowSet rs1=this.getDao().query(sql);
			
			while(rs1.next()){
				
				JSONObject json=new JSONObject();
				
				json.put("funcode", rs1.getString(0));
				json.put("funname", rs1.getString(1));
				
				jsonarry.put(json);
				
			}

		}else{
			throw new BusinessException("没有找到用户信息！");
		}
		
		retobj.put("perminfo", jsonarry);
		
		return retobj;

	}

	@Override
	public Map<String, Object> getApprovedDetail(String groupid, String userid,String taskid, String statuskey, String statuscode, int startline,int count) throws Exception {
		// TODO 自动生成的方法存根
		if(InvocationInfoProxy.getInstance().getGroupId()==null){
			InvocationInfoProxy.getInstance().setGroupId(groupid);
		}
		
		TaskMetaData tmd =  ExMobileAppUtil.queryTaskMetaData(statuskey, statuscode, taskid);
		
		ExApproveDetailQuery query = new ExApproveDetailQuery(tmd);
		List<Map<String, Object>> detailList = PaginationQueryFacade.getInstance().query(query, startline, count,1);
		
			
		Map<String, Object> resultMap = ExMobileAppUtil.createHashMap();
		
		JSONObject json=new JSONObject();
		
		json.put("billname", tmd.getBillNo());
		json.put("billtypename", Pfi18nTools.i18nBilltypeName(tmd.getBillType()));
		json.put("flowhistory", ((Map)detailList.get(0)).get("flowhistory"));
		
		resultMap.put("ApproveDetail", json);
		
		return resultMap;
		

	}

	@Override
	public Map<String, Object> getUserList(String groupid, String userid,String taskid, int startline, int count, String condition) throws BusinessException {
		// TODO 自动生成的方法存根
		
		
		List<Map<String, Object>> list = null;
	    
	    if (StringUtil.isEmptyWithTrim(condition)) {
	      UserQuery query = new UserQuery(groupid);
	      list = PaginationQueryFacade.getInstance().query(query, startline, count,1);
	    }
	    else {
	      UserMatcher matcher = new UserMatcher();
	      List<UserVO> matched = matcher.matchAll("pk_group='" + groupid + "'", condition);
	      List<UserVO> paginated = MobileAppUtil.subList(matched, startline, count);
	      
	      list = MobileAppUtil.createArrayList();
	      
	      for (UserVO uvo : paginated) {
	        Map<String, Object> map = MobileAppUtil.createHashMap();
	        
	        map.put("id", uvo.getCuserid());
	        map.put("code", uvo.getUser_code());
	        map.put("name", PfMultiLangUtil.getSuperVONameOfCurrentLang(uvo, "user_name"));
	        
	        list.add(map);
	      }
	    }
	    
	    Map<String, Object> result = MobileAppUtil.createHashMap();
	    result.put("psnstructlist", list);
	    
	    return result;
		
	}

	@Override
	public Map<String, Object> doAgree(String groupid, String userid,String taskid, String note, String cuserids) throws BusinessException {
		// TODO 自动生成的方法存根
		
		List<String> AssignUser=new ArrayList();
		  
		  if(cuserids != null){
			  
			  String[] users=cuserids.split(",");
			  
			  for(String user:users){
				  
				  if(!"nvl".equals(user)){
					  AssignUser.add(user);
				  }

			  }
			  
		  }
		  
		  
		  if(InvocationInfoProxy.getInstance().getGroupId()==null){
				InvocationInfoProxy.getInstance().setGroupId(groupid);
		  }
		  
		  InvocationInfoProxy.getInstance().setUserId(userid);
		  
		  
		  TaskMetaData tmd = ExMobileAppUtil.queryTaskMetaData("ishandled", "unhandled", taskid);
	 
	     
		  String billtype = tmd.getBillType();
		  String billid = tmd.getBillId();
		  String result = "Y";
	     
		  String[] assigned = null;
		  if (!ArrayUtil.isNull(AssignUser)) {
			  assigned = (String[])AssignUser.toArray(new String[0]);
		  }
		  
		  try{
	       PfUtilTools.approveSilently(billtype, billid, result, note, userid, assigned);
	     } catch (Exception e) {
	    	 ExMobileAppUtil.handleException(e);
	     }
		  
		  HashMap<String, Object> retobj=ExMobileAppUtil.createHashMap();
		  
		  retobj.put("appresult", "successed");
	     
		  return retobj;
	}

	@Override
	public Map<String, Object> getAssignPsnList(String groupid, String userid,String taskid, String isagree, int startline, int count,String condition) throws Exception {
		// TODO 自动生成的方法存根
		
		 if(InvocationInfoProxy.getInstance().getGroupId()==null){
				InvocationInfoProxy.getInstance().setGroupId(groupid);
		  }
		  
		  InvocationInfoProxy.getInstance().setUserId(userid);
			
		  WorkflownoteVO note = ExMobileAppUtil.checkWorkflow(taskid);
		  Vector<AssignableInfo> assignInfos = note.getTaskInfo().getAssignableInfos();
	    

		  List<Map<String, Object>> resultList = ExMobileAppUtil.createArrayList();
		  Map<String, String> useridDispatchIdMap = new HashMap();
		  String strCriterion;
		  Iterator i$; 
		  if ((assignInfos != null) && (assignInfos.size() > 0)) {
	      strCriterion = null;
	      for (i$ = assignInfos.iterator(); i$.hasNext();) 
	      { 
	    	  AssignableInfo ai = (AssignableInfo)i$.next();
	    	  strCriterion = ai.getCheckResultCriterion();
	        
	    	  if (((UFBoolean.valueOf(isagree).booleanValue()) && ((AssignableInfo.CRITERION_NOTGIVEN.equals(strCriterion)) || (AssignableInfo.CRITERION_PASS.equals(strCriterion)))) || ((!UFBoolean.valueOf(isagree).booleanValue()) && ((AssignableInfo.CRITERION_NOTGIVEN.equals(strCriterion)) || (AssignableInfo.CRITERION_NOPASS.equals(strCriterion)))))
	    	  {

	    		  Vector<OrganizeUnit> vt = ai.getOuUsers();
	          
	    		  if ((vt != null) && (vt.size() > 0)) {
	    		  for (OrganizeUnit ou : vt) {
	    			  Map<String, Object> map = ExMobileAppUtil.createHashMap();

	    			  String id = ou.getPk() + "#" + ai.getActivityDefId();

	    			  useridDispatchIdMap.put(ou.getPk(), id);
	              
	    			  map.put("id", id);
	    			  map.put("code", ou.getCode());
	    			  map.put("name", ou.getName());
	              
	    			  resultList.add(map);
	    		  }
	    		 }
	        }
	      }
	    }
	    AssignableInfo ai;
	    if (!StringUtil.isEmptyWithTrim(condition))
	    {
	      Map<Object, Map<String, Object>> converted = ExMobileAppUtil.convertToMap(resultList, "id");
	      
	      UserMatcher matcher = new UserMatcher();
	      
	      Set<String> cuseridSet = new HashSet();
	      
	      Iterator<Object> it = converted.keySet().iterator();
	      while (it.hasNext()) {
	        String id = (String)it.next();
	        id = id.substring(0, id.indexOf("#"));
	        
	        cuseridSet.add(id);
	      }
	      
	      List<UserVO> matched = matcher.matchWithin((String[])cuseridSet.toArray(new String[0]), condition);
	      

	      resultList = ExMobileAppUtil.createArrayList();
	      
	      for (UserVO uvo : matched) {
	        Map<String, Object> map = ExMobileAppUtil.createHashMap();
	        
	        map.put("id", useridDispatchIdMap.get(uvo.getCuserid()));
	        map.put("code", uvo.getUser_code());
	        map.put("name", PfMultiLangUtil.getSuperVONameOfCurrentLang(uvo, "user_name"));
	        

	        resultList.add(map);
	      }
	    }
	    
	    if ((resultList != null) && (resultList.size() > 0)) {
	      try {
	        Map<String, Object>[] array = (Map[])resultList.toArray(new Map[0]);
	        
	        Arrays.sort(array, new Comparator()
	        {
	          public int compare(Object o1, Object o2)
	          {
	            if (((o1 instanceof Map)) && ((o2 instanceof Map))) {
	              Object name1 = ((Map)o1).get("name");
	              Object name2 = ((Map)o2).get("name");
	              
	              if (((name1 instanceof String)) && ((name2 instanceof String)))
	              {
	                return ((String)name1).compareToIgnoreCase((String)name2);
	              }
	            }
	            

	            return 0;
	          }
	          

	        });
	        List<Map<String, Object>> tempList = ExMobileAppUtil.createArrayList();
	        

	        for (Map<String, Object> row : array) {
	          tempList.add(row);
	        }
	        
	        resultList = tempList;
	      } catch (Exception e) {
	        Logger.error(e.getMessage(), e);
	      }
	    }
	    
	    resultList = ExMobileAppUtil.subList(resultList, startline, count);
	    
	    
		  
		JSONArray jsons=new JSONArray();
		    
		for(Map<String,Object> map:resultList){
		    	
			JSONObject json=new JSONObject();
		    	
		    json.put("id", map.get("id"));
		    json.put("code", map.get("code"));
		    json.put("name", map.get("name"));
		    	
		    jsons.put(json);
		    	
		    	
	   }
	    
	    Map<String, Object> resultMap = ExMobileAppUtil.createHashMap();
	    resultMap.put("psnstructlist", jsons);
	    
	    return resultMap;
		

	}

	@Override
	public Map<String, Object> doDisAgree(String groupid, String userid,String taskid, String note, String cuserids) throws BusinessException {
		// TODO 自动生成的方法存根

		  if(InvocationInfoProxy.getInstance().getGroupId()==null){
				InvocationInfoProxy.getInstance().setGroupId(groupid);
		  }
		  
		  InvocationInfoProxy.getInstance().setUserId(userid);
			 
		  List<String> AssignUser=new ArrayList();
		  
		  if(cuserids != null){
			  
			  String[] users=cuserids.split(",");
			  
			  for(String user:users){
				  
				  if(!"nvl".equals(user)){
					  AssignUser.add(user);
				  }
				  


			  }
			  
		  } 
		  
		  TaskMetaData tmd = ExMobileAppUtil.queryTaskMetaData("ishandled", "unhandled", taskid);
	    

		  String billtype = tmd.getBillType();
		  String billid = tmd.getBillId();
		  String result = "N";
	    
		  String[] assigned = null;
		  if (!ArrayUtil.isNull(AssignUser)) {
			  assigned = (String[])AssignUser.toArray(new String[0]);
		  }
	    
		  try
		  {
			  PfUtilTools.approveSilently(billtype, billid, result, note, userid, assigned);
		  } catch (Exception e) {
			  ExMobileAppUtil.handleException(e);
		  }
		  
		  HashMap<String, Object> retobj=ExMobileAppUtil.createHashMap();
		  
		  retobj.put("appresult", "successed");
		     
		  return retobj;
	}

	@Override
	public Map<String, Object> doReject(String groupid, String userid,String taskid, String note, String nodeid) throws BusinessException {

		// TODO 自动生成的方法存根
		
		if(InvocationInfoProxy.getInstance().getGroupId()==null){
			
			  InvocationInfoProxy.getInstance().setGroupId(groupid);
		}
		  
		InvocationInfoProxy.getInstance().setUserId(userid);
		
		
	    TaskMetaData tmd = ExMobileAppUtil.queryTaskMetaData("ishandled", "unhandled", taskid);
		
		String billtype = tmd.getBillType();
		String billid = tmd.getBillId();
		AggregatedValueObject billvo = ExMobileAppUtil.queryBillEntity(billtype, billid);
		
		IWorkflowMachine srv = (IWorkflowMachine)NCLocator.getInstance().lookup(IWorkflowMachine.class);
		WorkflownoteVO worknoteVO = srv.checkWorkFlow("APPROVE", tmd.getBillType(), billvo, null);
		
		
		worknoteVO.setChecknote(note);
		worknoteVO.setApproveresult("R");
		worknoteVO.getTaskInfo().getTask().setTaskType(WfTaskType.Backward.getIntValue());
		worknoteVO.getTaskInfo().getTask().setSubmit2RjectTache(false);
		
		if (StringUtil.isEmptyWithTrim(nodeid)) {
		  worknoteVO.getTaskInfo().getTask().setBackToFirstActivity(true);
		  worknoteVO.getTaskInfo().getTask().setJumpToActivity(null);
		} else {
		  worknoteVO.getTaskInfo().getTask().setBackToFirstActivity(false);
		  worknoteVO.getTaskInfo().getTask().setJumpToActivity(nodeid);
		}
		
		
		
		IplatFormEntry entry = (IplatFormEntry)NCLocator.getInstance().lookup(IplatFormEntry.class);
		entry.processAction("APPROVE", billtype, worknoteVO, billvo, null, ExMobileAppUtil.createHashMap());
		
		HashMap<String, Object> retobj=ExMobileAppUtil.createHashMap();
		  
		retobj.put("appresult", "successed");
	     
		return retobj;
		
	
	}

	@Override
	public Map<String, Object> getRejectNodeList(String pk_group,String userid, String taskid, int startline,int count, String condition) throws Exception {
		// TODO 自动生成的方法存根
		

		// TODO 自动生成的方法存根
		
		if(InvocationInfoProxy.getInstance().getGroupId()==null){
				
			  InvocationInfoProxy.getInstance().setGroupId(pk_group);
		}
		  
		InvocationInfoProxy.getInstance().setUserId(userid);
		
		
		TaskMetaData tmd = ExMobileAppUtil.queryTaskMetaData("ishandled", "unhandled", taskid);
		WorkflownoteVO worknoteVO = ExMobileAppUtil.checkWorkflow(taskid);
		
		IWorkflowDefine srv = (IWorkflowDefine)NCLocator.getInstance().lookup(IWorkflowDefine.class);
		
		List<ProcessRouteRes> prrList = new ArrayList();
		     
		String billid = tmd.getBillId();
		String billtype = tmd.getBillType();
		     
		int workflowType = worknoteVO.getWorkflow_type().intValue();
		if (workflowType == WorkflowTypeEnum.SubWorkApproveflow.getIntValue()) {
		  String pk_wf_instance = worknoteVO.getTaskInfo().getTask().getWfProcessInstancePK();
		  ProcessRouteRes prr = srv.queryProcessRoute(tmd.getBillId(), tmd.getBillType(), pk_wf_instance, workflowType);
		  
		  prrList.add(prr);
		} else if (workflowType == WorkflowTypeEnum.SubApproveflow.getIntValue()) {
		  ProcessRouteRes prr = srv.queryProcessRoute(tmd.getBillId(), tmd.getBillType(), null, WorkflowTypeEnum.Approveflow.getIntValue());
		  prrList.add(prr);
		  
		  String pk_wf_instance = worknoteVO.getTaskInfo().getTask().getWfProcessInstancePK();
		  prr = srv.queryProcessRoute(billid, billtype, pk_wf_instance, workflowType);
		  prrList.add(prr);
		} else {
		  ProcessRouteRes prr = srv.queryProcessRoute(tmd.getBillId(), tmd.getBillType(), null, WorkflowTypeEnum.Approveflow.getIntValue());
		  prrList.add(prr);
		}
		
		
		try
		{
		  List<Map<String, Object>> resultList = getCheckedActivities((ProcessRouteRes[])prrList.toArray(new ProcessRouteRes[0]), condition);
		  
		
		  resultList = ExMobileAppUtil.subList(resultList, startline, count);
		  
		  
		  JSONArray jsons=new JSONArray();
		    
			for(Map<String,Object> map:resultList){
			    	
				JSONObject json=new JSONObject();
			    	
			    json.put("id", map.get("id"));
			    json.put("code", map.get("code"));
			    json.put("name", map.get("name"));
			    	
			    jsons.put(json);
			    	
			    	
		   }
		  
		  Map<String, Object> map = ExMobileAppUtil.createHashMap();
		  map.put("psnstructlist", jsons);
		  
		  return map;
		  
		} catch (Exception e) {
		 
			ExMobileAppUtil.handleException(e); 
		  
		}
		
		return null;

	
	}
	
	private List<Map<String, Object>> getCheckedActivities(ProcessRouteRes[] prs, String matchString) throws Exception{
		
	     List<Map<String, Object>> resultList = ExMobileAppUtil.createArrayList();
	     
	     if (prs != null) {
	       for (ProcessRouteRes p : prs) {
	         ActivityInstance[] ais = p.getActivityInstance();
	         WorkflowProcess wp = null;
	         if (p.getXpdlString() != null) {
	           String def_xpdl = p.getXpdlString().toString();
	           wp = UfXPDLParser.getInstance().parseProcess(def_xpdl);
	         }
	         
	         if (wp != null) {
	           for (ActivityInstance inst : ais) {
	             if (inst.getStatus() == WfTaskOrInstanceStatus.Finished.getIntValue())
	             {
	 
	 
	               Activity act = wp.findActivityByID(inst.getActivityID());
	               
	               if ((act instanceof GenericActivityEx)) {
	                 
	            	   GenericActivityEx gae = (GenericActivityEx)act;
	            	   Participant parti = wp.findParticipantByID(gae.getPerformer());
	                 
	            	   String name = parti.getName();
	                 
	 
	            	   if ((StringUtil.isEmptyWithTrim(matchString)) || (name.contains(matchString)))
	            	   {
	 
	 
	            		   String id = gae.getId();
	                   
	 
	            		   Map<String, Object> actEntry = ExMobileAppUtil.createHashMap();
	                   
	            		   actEntry.put("id", id);
	                   
	            		   actEntry.put("code", "");
	                   
	            		   actEntry.put("name", name);
	                   
	            		   resultList.add(actEntry);
	            	   } 
	               } else if ((act.getImplementation() instanceof SubFlow)) {
	            	   
	            	   		String id = act.getId();
	            	   		String code = act.getId();
	            	   		String name = act.getName();
	                 
	            	   		Map<String, Object> actEntry = ExMobileAppUtil.createHashMap();
	                 
	            	   		actEntry.put("id", id);
	                 
	            	   		actEntry.put("code", "");
	            	   		actEntry.put("name", name);
	                 
	            	   		resultList.add(actEntry);
	               }
	             }
	           }
	         }
	       }
	     }
	     
	     return resultList;
	   }

	@Override
	public List<Map<String, Object>> getRefDataList(String pk_group,String cond, String voclass, String entityname, String field,int startline, int count, int pagenum) throws BusinessException {
		// TODO 自动生成的方法存根
		 if(InvocationInfoProxy.getInstance().getGroupId()==null){
			  
			  if(pk_group==null || "~".equals(pk_group)){
				  InvocationInfoProxy.getInstance().setGroupId("0001A110000000000FJW");
			  }else{
				  InvocationInfoProxy.getInstance().setGroupId(pk_group);
			  }
			
			  
		  }
		
		  AbstractRefDataQuery refquery=new AbstractRefDataQuery();
		
		  refquery.setPk_group(pk_group);
		  if("nvl".equals(cond)){
			  refquery.setCondition(null);
		  }else{
			  refquery.setCondition(cond);
		  }
		  
		  if("nvl".equals(field)){
			  refquery.setFiled(null);
		  }else{
			  String[] dfileds=field.split(",");
			  for(String dfiled:dfileds){
				  refquery.getFiled().add(dfiled);
			  }
		  }
		  
		  refquery.setVoClassName(voclass);
		  refquery.setEntityname(entityname);
		  
		  List<Map<String, Object>> list;
		  
		  try {
				
			  refquery.setVoClass(Class.forName(voclass));
			  
			  refquery.MakeBasicSql();
				
			  list = PaginationQueryFacade.getInstance().query(refquery,startline,count,pagenum);
		
		  } catch (Exception e) {
				// TODO 自动生成的 catch 块
			throw new BusinessException(e.getMessage());
		  }

		  
		
		  return list;
	}

}
