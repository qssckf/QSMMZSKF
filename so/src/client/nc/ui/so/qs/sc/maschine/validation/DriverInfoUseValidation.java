//package nc.ui.so.qs.sc.maschine.validation;
//
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.List;
//
//import nc.bs.uif2.validation.IValidationService;
//import nc.bs.uif2.validation.ValidationException;
//import nc.bs.uif2.validation.ValidationFailure;
//import nc.md.model.MetaDataException;
//import nc.md.persist.framework.IMDPersistenceQueryService;
//import nc.md.persist.framework.MDPersistenceService;
//import nc.vo.pub.SuperVO;
//import nc.vo.so.xlx.tran.CarVO;
//
//public class DriverInfoUseValidation implements IValidationService {
//
//	@Override
//	public void validate(Object obj) throws ValidationException {
//		// TODO 自动生成的方法存根
//		
//		List<ValidationFailure> fs = new java.util.ArrayList();
//		
//		SuperVO[] vos = null;
//		if (obj.getClass().isArray()) {
//			vos = (SuperVO[])obj;
//		} else {
//			vos = new SuperVO[] { (SuperVO)obj };
//		}
//		
//		for(SuperVO vo:vos){
//			
//			try {
//				
//				String pk_user=(String) vo.getAttributeValue("pk_driver");
//				
//				Collection<CarVO> cars=this.getMDQueryService().queryBillOfVOByCond(CarVO.class,"(pk_driver='"+pk_user+"' or pk_driver1='"+pk_user+"' or pk_driver2='"+pk_user+"' or pk_escort='"+pk_user+"' or pk_escort1='"+pk_user+"' or pk_escort2='"+pk_user+"') and dr=0",false);
//								
//				Iterator it =cars.iterator();
//				
//				while(it.hasNext()){
//					CarVO item=(CarVO)it.next();
//					fs.add(new ValidationFailure("数据已被车辆"+item.getCode()+"使用，不能完成取消启用操作！"));
//				}
//				
//				
//			} catch (MetaDataException e) {
//				// TODO 自动生成的 catch 块
//				fs.add(new ValidationFailure(e.getMessage()));
//			}
//			
//			
//		}
//		
//		if(fs.size()>0){
//			throw new ValidationException(fs); 
//		}
//		
//	}
//	
//	
//	private IMDPersistenceQueryService getMDQueryService() {
//		
//		return MDPersistenceService.lookupPersistenceQueryService();
//	}
//
//}
