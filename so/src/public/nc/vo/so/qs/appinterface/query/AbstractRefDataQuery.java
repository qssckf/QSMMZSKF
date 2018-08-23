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
import nc.md.MDBaseQueryFacade;
import nc.md.model.IBusinessEntity;
import nc.vo.bd.meta.IBDObject;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.pf.mobileapp.exception.TaskNotValidException;
import nc.vo.pub.BusinessException;
import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;



public class AbstractRefDataQuery extends RefDataQuery {

	public AbstractRefDataQuery(){	
		
	}
	
	protected String getBaseSql() throws BusinessException{
		
		try{
			
			Class clz=this.getVoClass();
			
			Object obj=clz.newInstance();
			
			if(obj instanceof SuperVO){
				
				 SuperVO supvo=(SuperVO)obj;
				
				 IVOMeta meta=supvo.getMetaData();
				 
				 if(meta==null){
					 meta=VOMetaFactory.getInstance().getVOMeta(this.getEntityname());
				 }
				
				 IBusinessEntity bean=(IBusinessEntity) MDBaseQueryFacade.getInstance().getBeanByFullName(meta.getEntityName());
				
				 Map<String, String> name_attr_map = ((IBusinessEntity)bean).getBizInterfaceMapInfo(IBDObject.class.getName());
				 
				 this.setGroupfieldname(name_attr_map.get("pk_group"));
				 this.setOrgfieldname(name_attr_map.get("pk_org"));
				 this.setCodefieldname(name_attr_map.get("code"));
				 this.setNamefieldname(name_attr_map.get("name"));
				 this.setIdfieldname(name_attr_map.get("id"));
				
				 String tablename=bean.getTable().getName();
				
				 if (!StringUtil.isEmptyWithTrim(getCondition())){
					 
					 if(name_attr_map.get("pk_group")==null){
						 
						 String sql="select "+tablename+"."+this.getIdfieldname()+" from "+tablename+" where nvl(dr,0)=0 and ("+getCondition()+") order by "+tablename+"."+this.getCodefieldname();

						 return sql;
					 }
					 
					 String sql="select "+tablename+"."+this.getIdfieldname()+" from "+tablename+" where nvl(dr,0)=0 and pk_group='#pk_group#' and ("+getCondition()+") order by "+tablename+"."+this.getCodefieldname();

					 return sql;
				 }
				 
				 if(name_attr_map.get("pk_group")==null){
					 
					 String sql="select "+tablename+"."+this.getIdfieldname()+" from "+tablename+" where nvl(dr,0)=0 order by "+tablename+"."+this.getCodefieldname();
					 
					 return sql;
					 
				 }
				
				 
				 String sql="select "+tablename+"."+this.getIdfieldname()+" from "+tablename+" where nvl(dr,0)=0 and pk_group='#pk_group#' order by "+tablename+"."+this.getCodefieldname();
				 
				 return sql;
				
			}else{
				
				throw new BusinessException("����vo���Ͳ���ת��ΪSuperVO,����������ѯ��ʧ��");
			}
			
			
		}catch(Exception e){
			throw new BusinessException(e.getMessage());
		}
	
	}
	
	

	@Override
	public String getIdentifier() {
		// TODO �Զ����ɵķ������
		
		StringBuffer sb = new StringBuffer();
	    
	    sb.append(getPk_group());
	    sb.append(this.getVoClassName());

	    return sb.toString();
	}

	@Override
	public List<Map<String, Object>> queryByPks(String[] pks) throws BusinessException {
		// TODO �Զ����ɵķ������
		
		List<Map<String, Object>> list = new ArrayList();
		
		 for (String pk : pks) {
			 
			 SuperVO sup=querySuperVO(pk);
			 
			 Map<String, Object> map = convertToMap(sup);
			 list.add(map);
		 }
		 
		 return list;
		
	}
	
	

	private Map<String, Object> convertToMap(SuperVO sup) {
		// TODO �Զ����ɵķ������
		
		Map<String, Object> map = new HashMap();
		
		map.put("id", sup.getAttributeValue(this.getIdfieldname()));
		map.put("code", sup.getAttributeValue(this.getCodefieldname()));
		map.put("name", sup.getAttributeValue(this.getNamefieldname()));
		
		if(this.getFiled()!=null){
			
			for(String field:this.getFiled()){
				if(sup.getAttributeValue(field)!=null){
					map.put(field, sup.getAttributeValue(field));
				}else{
					map.put(field, "");
				}
				
			}
			
		}
		

		
	    return map;
	}

	private SuperVO querySuperVO(final String pk) throws BusinessException {
		// TODO �Զ����ɵķ������
		
		IRequestDataCacheKey key = new CondStringKey("mobileapp_ref_"+this.getVoClass().getName(), new String[] { pk });
		
		ICacheDataQueryCallback<SuperVO> callback = new ICacheDataQueryCallback(){
			@Override
			public Object queryData() throws BusinessException {
				// TODO �Զ����ɵķ������
					
				SuperVO sobj=(SuperVO) AbstractRefDataQuery.this.getQueryService().retrieveByPK(AbstractRefDataQuery.this.getVoClass(), pk);
					
				if(sobj==null){
					 throw new BusinessException("����pk:"+pk+"û���ҵ���������������");
				}

				return sobj;
			}
		};
		
		return (SuperVO)PFRequestDataCacheProxy.get(key, callback);
		
	}

	@Override
	public String getPksSql() {
		// TODO �Զ����ɵķ������
		String pk_group = getPk_group();
		
		String sql=null;
		
		sql=this.getPksql().replace("#pk_group#", pk_group);
		
		return sql;

	}
	
	public void MakeBasicSql() throws BusinessException{
		
		this.setPksql(this.getBaseSql());
	}

}
