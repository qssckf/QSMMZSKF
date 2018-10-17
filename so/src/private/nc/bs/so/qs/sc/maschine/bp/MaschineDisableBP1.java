package nc.bs.so.qs.sc.maschine.bp;

import nc.bs.bd.bp.rule.BDPKLockSuperVORule;
import nc.bs.bd.bp.rule.BizLockRule;
import nc.bs.bd.bp.rule.FireEventRule;
import nc.bs.bd.bp.rule.NotifyVersionChangeWhenDataUpdatedRule;
import nc.bs.bd.bp.rule.StringFieldTrimRule;
import nc.bs.bd.bp.rule.VersionValidateRule;
import nc.bs.bd.bp.rule.WriteBusiLogRule;
import nc.bs.bd.bp.rule.update.UpdateAuditInfoRule;
import nc.bs.bd.bp.template.DisableBPTemplate;
import nc.bs.bd.service.ValueObjWithErrLog;
import nc.bs.so.qs.sc.maschine.bp.template.UpdateWithFiledsBPTemplate;
import nc.bs.so.qs.sc.maschine.plugin.bpplugin.MaschinePluginPoint;
import nc.bs.so.qs.sc.maschine.rule.MaschineDisableDataCheckFilterRule;
import nc.bs.so.qs.sc.maschine.rule.MaschineDisableStatusFilterRule1;
import nc.bs.so.qs.sc.maschine.rule.MaschineSetStatusRule;
//import nc.bs.bd.so.xlx.driver.bp.template.UpdateWithFiledsBPTemplate;
//import nc.bs.bd.so.xlx.driver.plugin.bpplugin.DriverPluginPoint;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
//import nc.ui.so.xlx.driver.action.rule.DriverDisableDataCheckFilterRule;
//import nc.ui.so.xlx.driver.action.rule.DriverDisableStatusFilterRule;
//import nc.ui.so.xlx.driver.action.rule.DriverSetStatusRule;
//import nc.ui.so.xlx.driver.action.rule.DriverUnEnableDataCheckFilterRule;
//import nc.ui.so.xlx.driver.action.rule.DriverUnEnableStatusFilterRule;
//import nc.vo.so.xlx.tran.DriverVO;
//import nc.vo.so.qs.sc.AggMaschineVO;
import nc.vo.so.qs.sc.MaschineVO;

public class MaschineDisableBP1 {
	
	public MaschineDisableBP1(){}
	
	public ValueObjWithErrLog disable(MaschineVO[] vos, MaschineVO[] oldVos){
		
		ValueObjWithErrLog returnValue = new ValueObjWithErrLog();
//		DisableBPTemplate<MaschineVO> bpt=new UpdateWithFiledsBPTemplate(MaschinePluginPoint.DISABLE,new String[]{"dstatus","modifier","modifiedtime"});

		UpdateWithFiledsBPTemplate<MaschineVO> bpt=new UpdateWithFiledsBPTemplate(MaschinePluginPoint.DISABLE,new String[]{"mstatus","modifier","modifiedtime"});
		
		addBeforeRule(bpt.getAroundProcesser(),returnValue);
		
		addAfterRule(bpt.getAroundProcesser());
		
		returnValue.setVos(bpt.update(vos,oldVos));;
		
		return returnValue;
		
		
	}

	private void addAfterRule(CompareAroundProcesser<MaschineVO> aroundProcesser) {
		// TODO 自动生成的方法存根
		
		aroundProcesser.addAfterRule(new NotifyVersionChangeWhenDataUpdatedRule());
		
		aroundProcesser.addAfterRule(new FireEventRule("1069"));
		
		aroundProcesser.addAfterRule(new WriteBusiLogRule("Disable"));
		
	}

	private void addBeforeRule(CompareAroundProcesser<MaschineVO> aroundProcesser, ValueObjWithErrLog returnValue) {
		// TODO 自动生成的方法存根
		
		 aroundProcesser.addBeforeRule(new StringFieldTrimRule());
		
		 aroundProcesser.addBeforeRule(new BizLockRule());
		 
		 aroundProcesser.addBeforeRule(new MaschineDisableStatusFilterRule1());
		 
		 aroundProcesser.addBeforeRule(new MaschineDisableDataCheckFilterRule(returnValue));
		 
		 aroundProcesser.addBeforeRule(new MaschineSetStatusRule("mstatus","2"));
		 
		 aroundProcesser.addBeforeRule(new UpdateAuditInfoRule());
		 
		 aroundProcesser.addBeforeRule(new FireEventRule("1068"));
		 
	}

}
