package edu.umkc.tetris5;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class ControllerArch extends AbstractMyxSimpleBrick implements Controllerintf
{
    public static final IMyxName msg_Controllerintf = MyxUtils.createName("edu.umkc.tetris5.Controllerintf");
    public static final IMyxName msg_ClockOneinterface = MyxUtils.createName("edu.umkc.tetris5.ClockOneinterface");
    public static final IMyxName msg_ClockTwointerface = MyxUtils.createName("edu.umkc.tetris5.ClockTwointerface");

    public ClockOneinterface OUT_ClockOneinterface;
    public ClockTwointerface OUT_ClockTwointerface;

	private IControllerImp _imp;

    public ControllerArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IControllerImp getImplementation(){
        try{
			return new ControllerImp();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        OUT_ClockOneinterface = (ClockOneinterface) MyxUtils.getFirstRequiredServiceObject(this,msg_ClockOneinterface);
        if (OUT_ClockOneinterface == null){
 			System.err.println("Error: Interface edu.umkc.tetris5.ClockOneinterface returned null");
			return;       
        }
        OUT_ClockTwointerface = (ClockTwointerface) MyxUtils.getFirstRequiredServiceObject(this,msg_ClockTwointerface);
        if (OUT_ClockTwointerface == null){
 			System.err.println("Error: Interface edu.umkc.tetris5.ClockTwointerface returned null");
			return;       
        }
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		if (arg0.equals(msg_Controllerintf)){
			return this;
		}        
		return null;
	}
  
    
    public void result (String player)   {
		_imp.result(player);
    }    
}