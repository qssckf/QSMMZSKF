package nc.impl.so.qs.sc.maschine.bill;

//import nc.bs.pd.pd0404.bp.PDWkDeleteBP;
//import nc.bs.pd.pd0404.bp.PDWkInsertBP;
//import nc.bs.pd.pd0404.bp.PDWkUpdateBP;
import nc.bs.bd.bp.utils.MDQueryUtil;
import nc.bs.bd.service.ValueObjWithErrLog;
import nc.bs.so.qs.sc.maschine.bp.MaschineDeleteBP;
import nc.bs.so.qs.sc.maschine.bp.MaschineDisableBP1;
import nc.bs.so.qs.sc.maschine.bp.MaschineEnableBP;
import nc.bs.so.qs.sc.maschine.bp.MaschineEnableBP1;
import nc.bs.so.qs.sc.maschine.bp.MaschineInsertBP;
import nc.bs.so.qs.sc.maschine.bp.MaschineUnEnableBP1;
import nc.bs.so.qs.sc.maschine.bp.MaschineUpdateBP;
import nc.impl.pubapp.pattern.data.bill.tool.BillTransferTool;
//import nc.itf.pd.pd0404.IPDWkMaintain;
import nc.util.mmf.framework.base.MMValueCheck;
//import nc.vo.pd.pd0404.entity.AggWkVO;
//import nc.vo.pd.pd0404.entity.WkProdinvVO;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.util.BDPKLockUtil;
import nc.vo.util.BDVersionValidationUtil;
import nc.itf.so.qs.sc.maschine.service.IMaschineMaintain;
import nc.vo.so.qs.sc.AggMaschineVO;
import nc.vo.so.qs.sc.MachineMater_Mater;
import nc.vo.so.qs.sc.MaschineVO;


public class MaschineMaintainImpl implements IMaschineMaintain {
	public MaschineMaintainImpl() {}
  
	public AggMaschineVO[] insert(AggMaschineVO[] vos) throws BusinessException{
		if (vos == null) {
			return null;
			}
		try {
			BillTransferTool<AggMaschineVO> transTool = new BillTransferTool(vos);
			AggMaschineVO[] fullBills = (AggMaschineVO[])transTool.getClientFullInfoBill();
			MaschineInsertBP insertBP = new MaschineInsertBP();
			AggMaschineVO[] rtnvos = insertBP.insert(fullBills);
			return (AggMaschineVO[])transTool.getBillForToClient(rtnvos);
			}
		catch (Exception e) {
			ExceptionUtils.marsh(e);
			}
		return null;
		}
  
	public AggMaschineVO[] update(AggMaschineVO[] vos) throws BusinessException {
		if (vos == null) {
			return null;
			}
		try {
			if (vos[0].getChildren(MachineMater_Mater.class).length != 0)
			{
				BDPKLockUtil.lockSuperVO((MachineMater_Mater[])vos[0].getChildren(MachineMater_Mater.class));
				BDVersionValidationUtil.validateSuperVO((MachineMater_Mater[])vos[0].getChildren(MachineMater_Mater.class));
				}

			BillTransferTool<AggMaschineVO> transTool = new BillTransferTool(vos);
			AggMaschineVO[] fullBills = (AggMaschineVO[])transTool.getClientFullInfoBill();
			AggMaschineVO[] originVOs = (AggMaschineVO[])transTool.getOriginBills();
			MaschineUpdateBP updateBP = new MaschineUpdateBP();
			AggMaschineVO[] rtnvos = updateBP.update(fullBills, originVOs);
			return (AggMaschineVO[])transTool.getBillForToClient(rtnvos);
			}
		catch (Exception e) {
			ExceptionUtils.marsh(e);
			}
		return null;
		}
  
	public void delete(AggMaschineVO[] vos) throws BusinessException {
		if (vos == null) {
			return;
			}
		try {
			if ((MMValueCheck.isNotEmpty(vos[0].getChildren(MachineMater_Mater.class))) && (vos[0].getChildren(MachineMater_Mater.class).length != 0)){
				BDPKLockUtil.lockSuperVO((MachineMater_Mater[])vos[0].getChildren(MachineMater_Mater.class));
				BDVersionValidationUtil.validateSuperVO((MachineMater_Mater[])vos[0].getChildren(MachineMater_Mater.class));
				}
			BillTransferTool<AggMaschineVO> transTool = new BillTransferTool(vos);
      
			AggMaschineVO[] fullBills = (AggMaschineVO[])transTool.getClientFullInfoBill();
			MaschineDeleteBP deleteBP = new MaschineDeleteBP();
			deleteBP.delete(fullBills);
			}
		catch (Exception e) {
			ExceptionUtils.marsh(e);
			}
		}

@Override
	public ValueObjWithErrLog enableMaschine(MaschineVO[] obs)throws BusinessException {
		// TODO 自动生成的方法存根
		try{
			MaschineVO[] oldVos = (MaschineVO[])MDQueryUtil.lockValidateToRetrieveVO(obs);		
			MaschineEnableBP1 action=new MaschineEnableBP1();	
			return action.enable(obs, oldVos);
		
		}catch(Exception e){
			ExceptionUtils.marsh(e);
		}
		return null;
	}
@Override
	public ValueObjWithErrLog unenableMaschine(MaschineVO[] obs) throws BusinessException {
		// TODO 自动生成的方法存根
		try{
		
			MaschineVO[] oldVos = (MaschineVO[])MDQueryUtil.lockValidateToRetrieveVO(obs);
		
			MaschineUnEnableBP1 action=new MaschineUnEnableBP1();
		
			return action.unenable(obs, oldVos);
		}catch(Exception e){
			ExceptionUtils.marsh(e);
		}
		return null;
	}
@Override
	public ValueObjWithErrLog disableMaschine(MaschineVO[] obs) throws BusinessException {
		// TODO 自动生成的方法存根
		try{
		
			MaschineVO[] oldVos = (MaschineVO[])MDQueryUtil.lockValidateToRetrieveVO(obs);
		
			MaschineDisableBP1 action=new MaschineDisableBP1();
		
			return action.disable(obs, oldVos);
		
		}catch(Exception e){
			ExceptionUtils.marsh(e);
		}
		return null;
		}

@Override
	public AggMaschineVO enable(AggMaschineVO obj) throws BusinessException {
		// TODO 自动生成的方法存根
		BillPageLazyQuery<AggMaschineVO> query=new BillPageLazyQuery(AggMaschineVO.class);

		AggMaschineVO[] oldobj=(AggMaschineVO[])query.queryPageBills(new String[]{obj.getParentVO().getPk_tranflow_h()});
	
		MaschineEnableBP bp=new MaschineEnableBP();
	
		return bp.enable(new AggMaschineVO[]{obj},oldobj)[0];
	}

@Override
	public AggMaschineVO unable(AggMaschineVO obj) throws BusinessException {
		// TODO 自动生成的方法存根
		
	
	
		return null;
	}

@Override
	public AggMaschineVO disable(AggMaschineVO obj) throws BusinessException {
		// TODO 自动生成的方法存根
		return null;
	} 
}
