package nc.ui.so.qs.mmplanbill.model;

import nc.ui.querytemplate.querytree.FromWhereSQL;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.ui.so.qs.mmplanbill.service.PlanBillAppModelService;
import nc.ui.uif2.components.pagination.IPaginationModelListener;
import nc.ui.uif2.components.pagination.IPaginationQueryService;
import nc.ui.uif2.components.pagination.PaginationModel;
import nc.ui.uif2.model.IAppModelDataManagerEx;
import nc.ui.uif2.model.IQueryAndRefreshManagerEx;
import nc.vo.pub.BusinessException;

public class PlanBillDataManager implements IAppModelDataManagerEx,IQueryAndRefreshManagerEx,IPaginationModelListener{

	
	private PaginationModel paginationModel = null;
	private PlanBillAppModelService service;
	
	public PlanBillAppModelService getService() {
		return service;
	}

	public void setService(PlanBillAppModelService service) {
		this.service = service;
	}

	public PaginationModel getPaginationModel() {
		return paginationModel;
	}

	public void setPaginationModel(PaginationModel paginationModel) {
		this.paginationModel = paginationModel;
		paginationModel.addPaginationModelListener(this);
		paginationModel.setPaginationQueryService(new IPaginationQueryService(){

			@Override
			public Object[] queryObjectByPks(String[] pks) throws BusinessException {
				// TODO 自动生成的方法存根
				return PlanBillDataManager.this.getService().queryVOsByPks(pks);
			}
			
		});
	}
	
	private IQueryScheme scheme = new IQueryScheme(){

		@Override
		public Object get(String arg0) {
			// TODO 自动生成的方法存根
			return null;
		}

		@Override
		public String getName() {
			// TODO 自动生成的方法存根
			return null;
		}

		@Override
		public FromWhereSQL getTableJoinFromWhereSQL() {
			// TODO 自动生成的方法存根
			return null;
		}

		@Override
		public FromWhereSQL getTableListFromWhereSQL() {
			// TODO 自动生成的方法存根
			return null;
		}

		@Override
		public String getWhereSQLOnly() {
			// TODO 自动生成的方法存根
			return null;
		}

		@Override
		public void put(String arg0, Object arg1) {}
		
	};

	@Override
	public void refresh() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void initModelBySqlWhere(String paramString) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void initModelBySqlWhere(IQueryScheme queryscheme) {
		// TODO 自动生成的方法存根
		
		this.scheme=queryscheme;
		String[] pks=null;
		pks = queryByCon(queryscheme.getWhereSQLOnly());
		setDriverVOPKsTOPaginationModel(pks);
		
		
	}

	private void setDriverVOPKsTOPaginationModel(String[] pks) {
		// TODO 自动生成的方法存根
		
	}

	private String[] queryByCon(String whereSQLOnly) {
		// TODO 自动生成的方法存根
		
		
		return null;
	}

	@Override
	public void initModel() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void onStructChanged() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void onDataReady() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void setShowSealDataFlag(boolean paramBoolean) {
		// TODO 自动生成的方法存根
		
	}

}
