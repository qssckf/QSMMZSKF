package nc.vo.so.qs.appinterface.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.bs.pf.pub.PFRequestDataCacheProxy;
import nc.bs.pf.pub.PfDataCache;
import nc.bs.pf.pub.cache.CondStringKey;
import nc.bs.pf.pub.cache.ICacheDataQueryCallback;
import nc.bs.pf.pub.cache.IRequestDataCacheKey;
import nc.vo.bd.cust.CustomerVO;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.org.SalesOrgVO;
import nc.vo.pf.mobileapp.exception.TaskNotValidException;
import nc.vo.pub.BusinessException;
import nc.vo.pub.billtype.BilltypeVO;
import nc.vo.so.m38.entity.PreOrderHVO;
import nc.vo.so.qs.appinterface.util.BillQuery;
import nc.vo.so.qs.appinterface.util.TaskMetaData;

public abstract class AbstractPreOrderQuery extends BillQuery{
	
	
	protected String getBaseSql(){
	    
		if (!StringUtil.isEmptyWithTrim(getCondition()))
	    {
	      String sql = "select so_preorder.cpreorderid,so_preorder.dbilldate from so_preorder left join so_preorder_b on so_preorder.cpreorderid=so_preorder_b.cpreorderid where so_preorder.dr=0 and so_preorder_b.dr=0  and so_preorder.pk_group='#pk_group#' and so_preorder.billmaker='#billmaker#' and substr(so_preorder.dmakedate,0,10)<='#date#' and ("+this.getCondition()+") group by so_preorder.fstatusflag,so_preorder.cpreorderid,so_preorder.dbilldate order by so_preorder.fstatusflag,so_preorder.cpreorderid,so_preorder.dbilldate desc";
	
	      return sql;
	    }
		
	    return "select so_preorder.cpreorderid,so_preorder.dbilldate from so_preorder left join so_preorder_b on so_preorder.cpreorderid=so_preorder_b.cpreorderid where so_preorder.dr=0 and so_preorder_b.dr=0  and so_preorder.pk_group='#pk_group#' and so_preorder.billmaker='#billmaker#' and substr(so_preorder.dmakedate,0,10)<='#date#' group by so_preorder.fstatusflag,so_preorder.cpreorderid,so_preorder.dbilldate order by so_preorder.fstatusflag,so_preorder.cpreorderid,so_preorder.dbilldate desc";
	}
	

	@Override
	public TaskMetaData queryTaskMetaData(final String pk) throws BusinessException {
		// TODO �Զ����ɵķ������
		
		IRequestDataCacheKey key = new CondStringKey("mobileapp_preorder_querytaskmetadata", new String[] { pk });
		ICacheDataQueryCallback<TaskMetaData> callback = new ICacheDataQueryCallback()
		{
			public TaskMetaData queryData() throws BusinessException{
				
				PreOrderHVO note = (PreOrderHVO)AbstractPreOrderQuery.this.getQueryService().retrieveByPK(PreOrderHVO.class, pk);
	        
				if (note == null) {
					throw new TaskNotValidException();
				}
	        
				return AbstractPreOrderQuery.this.convertToMeta(note);
	      }
	      
	    };
	    return (TaskMetaData)PFRequestDataCacheProxy.get(key, callback);
	    
	}
	
	protected TaskMetaData convertToMeta(PreOrderHVO note) throws BusinessException {
		// TODO �Զ����ɵķ������
		TaskMetaData tmd=new TaskMetaData();
		
		tmd.setBillType(note.getVtrantypecode());
		tmd.setBillId(note.getCpreorderid());
		tmd.setBillNo(note.getVbillcode());
		tmd.setCuserid(note.getBillmaker());
		tmd.setStartDate(note.getDbilldate().toString().substring(0,10));
		tmd.setFstatusflag(note.getFstatusflag());
		tmd.setTitle(MakeTitle(note));
		return tmd;
	}

	private String MakeTitle(PreOrderHVO note) throws BusinessException {
		// TODO �Զ����ɵķ������
		BilltypeVO btvo = PfDataCache.getBillTypeInfo(note.getVtrantypecode());
		
		if(btvo==null){
			throw new BusinessException("Ԥ������"+note.getVbillcode()+"��������Ϊ�գ����ܼ�����ɻ�ȡ�б����");
		}
		
		SalesOrgVO orgs=(SalesOrgVO)getQueryService().retrieveByPK(SalesOrgVO.class, note.getPk_org());
		
		if(orgs==null){
			throw new BusinessException("Ԥ������"+note.getVbillcode()+"������֯Ϊ�գ����ܼ�����ɻ�ȡ�б����");
		}
		
		CustomerVO cus=(CustomerVO)getQueryService().retrieveByPK(CustomerVO.class, note.getCcustomerid());
		
		if(cus==null){
			throw new BusinessException("Ԥ������"+note.getVbillcode()+"�ͻ�Ϊ�գ����ܼ�����ɻ�ȡ�б����");
		}
		

		String title="�ͻ���"+cus.getName()+" "+"����ʱ�䣺"+note.getDbilldate()+" "+"�������ͣ�"+btvo.getBilltypename()+" "+"���ݱ�ţ�"+note.getVbillcode()+" "+"����������"+note.getNtotalnum();

		return title;
	}



	@Override
	public List<Map<String, Object>> queryByPks(String[] pks) throws BusinessException {
		// TODO �Զ����ɵķ������
		
		List<Map<String, Object>> list = new ArrayList();
		
		for (String pk : pks) {
			 
			 TaskMetaData tmd = queryTaskMetaData(pk);
			 Map<String, Object> map = convertToTask(tmd);
			 list.add(map);
		 }
		 
		 return list;
		

	}
	
	private Map<String, Object> convertToTask(TaskMetaData tmd) {
	    
		Map<String, Object> map = new HashMap();
	    
	    map.put("billid", tmd.getBillId());
	    map.put("billstatus", tmd.getFstatusflag());
	    map.put("date", tmd.getStartDate());
	    map.put("title", tmd.getTitle());
	    map.put("billtype", tmd.getBillType());
	    
	    return map;
	}

}
