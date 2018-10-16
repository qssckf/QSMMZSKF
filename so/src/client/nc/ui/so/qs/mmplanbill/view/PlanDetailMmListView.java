package nc.ui.so.qs.mmplanbill.view;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;

import nc.bs.framework.common.NCLocator;
import nc.funcnode.ui.FuncletInitData;
import nc.funcnode.ui.FuncletWindowLauncher;
import nc.itf.so.qs.sc.planbill.service.IPlanBillSerive;
import nc.md.persist.framework.IMDPersistenceQueryService;
import nc.md.persist.framework.MDPersistenceService;
import nc.sfbase.client.ClientToolKit;
import nc.ui.dcm.chnlrplstrct.maintain.action.MessageDialog;
import nc.ui.ml.NCLangRes;
import nc.ui.pf.change.PfUtilUITools;
import nc.ui.pf.pub.PfUIDataCache;
import nc.ui.pub.bill.BillItemHyperlinkEvent;
import nc.ui.pub.bill.BillItemHyperlinkListener;
import nc.ui.pub.linkoperate.ILinkQueryData;
import nc.ui.pub.msg.PfLinkData;
import nc.ui.pubapp.uif2app.view.ShowUpableBillListView;
import nc.ui.sm.power.FuncRegisterCacheAccessor;
import nc.ui.so.qs.mmplanbill.model.PlanDetailMManageAppModel;
import nc.ui.so.qs.mmplanbill.model.PlanDetailManageAppModel;
import nc.ui.so.qs.mmplanbill.readyplan.model.PlanDetailPara;
import nc.ui.so.qs.pub.tools.ScreenTools;
import nc.ui.uif2.ShowStatusBarMsgUtil;
import nc.vo.mmpac.pmo.pac0002.entity.PMOAggVO;
import nc.vo.mmpac.pmo.pac0002.entity.PMOHeadVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.pub.billtype.BilltypeVO;
import nc.vo.sm.funcreg.FuncRegisterVO;
import nc.vo.so.qs.sc.PlanProduceDetailVO;
import nc.vo.so.qs.sc.RdPorductDetailVO;

public class PlanDetailMmListView extends ShowUpableBillListView{
	
	private IPlanBillSerive planservice;
	private PlanDetailManageAppModel rdmodel;
	public static final String[] LinkQueryBusiActiveCodes = { "LinkQuery" };
	private int openMode = 1;
	

	public PlanDetailManageAppModel getRdmodel() {
		return rdmodel;
	}

	public void setRdmodel(PlanDetailManageAppModel rdmodel) {
		this.rdmodel = rdmodel;
	}

	public IPlanBillSerive getPlanservice() {
		
		if(this.planservice==null){
			
			this.planservice=NCLocator.getInstance().lookup(IPlanBillSerive.class);
			
		}
		
		return planservice;
	}
	
	public static IMDPersistenceQueryService getMDQueryService(){
		
		return MDPersistenceService.lookupPersistenceQueryService();
		
	}

	@Override
	public void initUI() {
		// TODO �Զ����ɵķ������
		super.initUI();
		
		this.getBillListPanel().getHeadItem("detail").addBillItemHyperlinkListener(new BillItemHyperlinkListener(){

			@Override
			public void hyperlink(BillItemHyperlinkEvent event) {
				// TODO �Զ����ɵķ������
				

				// TODO �Զ����ɵķ������
				
				FuncRegisterVO frVO = FuncRegisterCacheAccessor.getInstance().getFuncRegisterVOByFunCode("4006200203");
				
				if(frVO!=null){
					
					FuncletInitData funInitData = new FuncletInitData();
					
					PlanDetailPara initdata=new PlanDetailPara();
					
					
					try{
						
						RdPorductDetailVO selectVo=(RdPorductDetailVO) PlanDetailMmListView.this.getModel().getSelectedData();
						
						if(selectVo==null){
							
							ShowStatusBarMsgUtil.showErrorMsg("����", "û�еõ����������!", PlanDetailMmListView.this.getModel().getContext());
							
							return;
						}
						
						String srcbid=selectVo.getVsrcplanbid();
						
						PlanProduceDetailVO pd=PlanDetailMmListView.this.getMDQueryService().queryBillOfVOByPK(PlanProduceDetailVO.class, srcbid, false);
						
						//��֤ts
						PlanDetailMmListView.this.getPlanservice().validateVOTs(new SuperVO[]{pd});
							

						initdata.setPlanVo(selectVo);
						
						initdata.setModel(PlanDetailMmListView.this.getRdmodel());
						initdata.setCmodel(PlanDetailMmListView.this.getModel());
						initdata.setList(PlanDetailMmListView.this);
						initdata.setOperatype("EDIT");
						
						if(selectVo.getBillstatus()!=1 || pd.getTotalnum().toDouble()>=pd.getPlannum().toDouble()){
							initdata.setEdit(false);
						}else{
							initdata.setEdit(true);
						}
						
						
						funInitData.setInitData(initdata);	
						

						int w = 680;
						int h = 680;
						if ((ScreenTools.getScreen().width == 1024) && (ScreenTools.getScreen().height == 768))
						{
							w = 780;
						}
						
						FuncletWindowLauncher.openFuncNodeDialog(PlanDetailMmListView.this.getModel().getContext().getEntranceUI(), frVO, funInitData, null, true, false, ScreenTools.newDimension(w, h));

					}catch(nc.bs.uif2.VersionConflictException e0){
						
						ShowStatusBarMsgUtil.showErrorMsg("����","�������� ��չ����ϸ�������޸ģ���ˢ�º����ԣ�", PlanDetailMmListView.this.getModel().getContext());
						
						return;
						
					}catch(BusinessException e){
						
						ShowStatusBarMsgUtil.showErrorMsg("����",e.getMessage(), PlanDetailMmListView.this.getModel().getContext());
						
						return;
					}
					

				}else{
					
					ShowStatusBarMsgUtil.showErrorMsg("����", "û���ҵ�ҵ����Ĺ��ܽڵ�", PlanDetailMmListView.this.getModel().getContext());
					
					return;
					
				}
				
			}
			
		});
		
		this.getBillListPanel().getHeadItem("def2").addBillItemHyperlinkListener(new BillItemHyperlinkListener(){

			@Override
			public void hyperlink(BillItemHyperlinkEvent event) {
				// TODO �Զ����ɵķ������
				
				try{
					
					
					
					String vbillcode=(String) event.getValue();
					
					if(vbillcode!=null){
						
						BilltypeVO resultVO = PfUIDataCache.getBillType("55A2");
						
						Collection<PMOAggVO> col=PlanDetailMmListView.this.getMDQueryService().queryBillOfVOByCond(PMOHeadVO.class,"vbillcode='"+vbillcode+"' and dr=0",false);
						
						if(col!=null && col.size()>0){
							
							PMOAggVO agg=col.toArray(new PMOAggVO[col.size()])[0];
			
							final PMOHeadVO head=agg.getParentVO();
							
							PfLinkData pflink = new PfLinkData();
							pflink.setBillID(head.getCpmohid());
							pflink.setBillType("55A2");
							pflink.setUserObject("APPROVE");
							
							String customNode = PfUtilUITools.findCustomNodeOfBilltype(resultVO, pflink);
							
							String nodecode = customNode;
							
							if (StringUtils.isEmpty(customNode)) {
								nodecode = resultVO.getNodecode();
							}
							
							if (StringUtils.isEmpty(nodecode)) {
								MessageDialog.showHintDlg(null, NCLangRes.getInstance().getStrByID("101203", "UPP101203-000036"), NCLangRes.getInstance().getStrByID("pfworkflow", "noNodeView"));
								
								return;
							}
							
							FuncRegisterVO funcregvo = FuncRegisterCacheAccessor.getInstance().getFuncRegisterVOByFunCode(nodecode);
							
							if (funcregvo == null) {
									
								MessageDialog.showErrorDlg(ClientToolKit.getApplet(), NCLangRes.getInstance().getStrByID("sysframev5", "UPPsysframev5-000062"), NCLangRes.getInstance().getStrByID("sysframev5", "UPPsysframev5-000095") + nodecode);
								
							}
							
		
							ILinkQueryData qryData = new ILinkQueryData() {
								public String getBillID() {
									return head.getCpmohid();
								}
								
								public String getBillType() {
									return "55A2";
								}
								
								public String getPkOrg() {
									return head.getPk_org();
								}
								
								public Object getUserObject() {
									return null;
								}
							};
							
							FuncletInitData initData = new FuncletInitData(3, qryData);
							
							FuncletWindowLauncher.openFuncNodeForceModalDialog(PlanDetailMmListView.this.getModel().getContext().getEntranceUI(), funcregvo, initData, null, null, false, null, openMode == 1 ? null : LinkQueryBusiActiveCodes);
							
							
							
						}else{
							
							MessageDialog.showHintDlg(PlanDetailMmListView.this, "��ʾ", "���ݵ��ݺ�û���ҵ���������������������");
							
							return;
							
						}
						
						
						
					}else{
						
						throw new BusinessException("û�еõ����������ţ��޷���ѯ!");
						
					}
					
					
					
				}catch(Exception e){
					
					ShowStatusBarMsgUtil.showErrorMsg("����",e.getMessage(), PlanDetailMmListView.this.getModel().getContext());
					
					return;
					
				}
				
				
			}
			
		});
		
		
	}
	
	

}
