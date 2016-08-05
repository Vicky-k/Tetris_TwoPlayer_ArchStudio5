package edu.umkc.tetris5;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class SecondPlayerClockArch extends AbstractMyxSimpleBrick implements ClockTwointerface
{
    public static final IMyxName msg_ClockTwointerface = MyxUtils.createName("edu.umkc.tetris5.ClockTwointerface");


	private ISecondPlayerClockImp _imp;

    public SecondPlayerClockArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected ISecondPlayerClockImp getImplementation(){
        try{
			return new SecondPlayerClockImp();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		if (arg0.equals(msg_ClockTwointerface)){
			return this;
		}        
		return null;
	}
  
    
    public void initialize (float cyclesPerSecond)   {
		_imp.initialize(cyclesPerSecond);
    }    
    public void setCyclesPerSecond (float cyclesPerSecond)   {
		_imp.setCyclesPerSecond(cyclesPerSecond);
    }    
    public void reset ()   {
		_imp.reset();
    }    
    public void update ()   {
		_imp.update();
    }    
    public void setPaused (boolean paused)   {
		_imp.setPaused(paused);
    }    
    public boolean isPaused ()   {
		return _imp.isPaused();
    }    
    public boolean hasElapsedCycle ()   {
		return _imp.hasElapsedCycle();
    }    
    public boolean peekElapsedCycle ()   {
		return _imp.peekElapsedCycle();
    }    
    public long getCurrentTime ()   {
		return _imp.getCurrentTime();
    }    
}