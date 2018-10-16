package nc.ui.so.qs.mmplanbill.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import nc.bs.framework.common.InvocationInfoProxy;
import nc.bs.uif2.BusinessExceptionAdapter;
import nc.md.model.MetaDataException;
import nc.md.persist.framework.IMDPersistenceQueryService;
import nc.md.persist.framework.MDPersistenceService;
import nc.ui.pubapp.uif2app.query2.model.IModelDataManager;
import nc.ui.querytemplate.filter.IFilter;
import nc.ui.querytemplate.querytree.FromWhereSQL;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.ui.querytemplate.value.IFieldValue;
import nc.ui.querytemplate.value.IFieldValueElement;
import nc.ui.so.qs.mmplanbill.service.PlanBillAppModelService;
import nc.ui.uif2.IShowMsgConstant;
import nc.ui.uif2.ShowStatusBarMsgUtil;
import nc.ui.uif2.components.pagination.BillManagePaginationDelegator;
import nc.ui.uif2.components.pagination.IPaginationModelListener;
import nc.ui.uif2.components.pagination.IPaginationQueryService;
import nc.ui.uif2.components.pagination.PaginationModel;
import nc.ui.uif2.model.AbstractUIAppModel;
import nc.ui.uif2.model.IAppModelDataManagerEx;
import nc.ui.uif2.model.IQueryAndRefreshManager;
import nc.ui.uif2.model.IQueryAndRefreshManagerEx;
import nc.vo.logging.Debug;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.so.qs.sc.RdPorductDetailVO;
import nc.vo.util.SqlWhereUtil;

public class RdItemDataManager implements IModelDataManager,IQueryAndRefreshManager{

	private AbstractUIAppModel model;
	private IQueryScheme scheme;
	private String sqlWhere;

	public AbstractUIAppModel getModel() {
		return model;
	}

	public void setModel(AbstractUIAppModel model) {
		this.model = model;
	}

	public static IMDPersistenceQueryService getMDQueryService(){
		
		return MDPersistenceService.lookupPersistenceQueryService();
		
	}
	
	@Override
	public void initModel() {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void initModelByQueryScheme(IQueryScheme qryScheme) {
		// TODO �Զ����ɵķ������
		
		try{
			
			this.scheme = qryScheme;
			
			RdPorductDetailVO[] data=null;
			
			data = queryRdVOByCon(qryScheme.getWhereSQLOnly());
			
			this.getModel().initModel(data);
			
			if ((data == null) || (data.length == 0)) {
				ShowStatusBarMsgUtil.showStatusBarMsg(IShowMsgConstant.getQueryNullInfo(), getModel().getContext());
			}else {
				ShowStatusBarMsgUtil.showStatusBarMsg(IShowMsgConstant.getQuerySuccessInfo(data.length), getModel().getContext());
			}
			
			
		}catch(Exception e){
			ExceptionUtils.wrappException(e);
		}
	
		
	}

	private RdPorductDetailVO[] queryRdVOByCon(String con) throws MetaDataException {
		// TODO �Զ����ɵķ������
		
		RdPorductDetailVO[] rdVos=null;
		
		String wheresql=createCondition(this.sqlWhere);
		
		this.sqlWhere=wheresql;
		
		Collection<RdPorductDetailVO> col=this.getMDQueryService().queryBillOfVOByCond(RdPorductDetailVO.class, wheresql, false);
		
		return col.toArray(new RdPorductDetailVO[col.size()]);
	}

	private String createCondition(String sqlWhere2) {
		// TODO �Զ����ɵķ������
		
		SqlWhereUtil swu = new SqlWhereUtil();
		swu.s("billstatus=2 and processer='"+InvocationInfoProxy.getInstance().getUserId()+"' ");
		swu.and(sqlWhere2);
		return swu.getSQLWhere();
	}

	@Override
	public void refresh() {
		// TODO �Զ����ɵķ������
		this.initModelByQueryScheme(this.scheme);
	}

	@Override
	public void initModelBySqlWhere(String paramString) {
		// TODO �Զ����ɵķ������
		
	}

	

}
