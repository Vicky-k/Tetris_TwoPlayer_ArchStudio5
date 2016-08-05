package edu.umkc.tetris5;


import edu.umkc.tetris5.FirstPlayerClockArch;

public interface IFirstPlayerClockImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (FirstPlayerClockArch arch);
	public FirstPlayerClockArch getArch();
	
	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init();	
	public void begin();
	public void end();
	public void destroy();

	/*
  	  Implementation primitives required by the architecture
	*/
  
    
    public void initialize (float cyclesPerSecond)  ;        
    public void setCyclesPerSecond (float cyclesPerSecond)  ;        
    public void reset ()  ;        
    public void update ()  ;        
    public void setPaused (boolean paused)  ;        
    public boolean isPaused ()  ;        
    public boolean hasElapsedCycle ()  ;        
    public boolean peekElapsedCycle ()  ;        
    public long getCurrentTime ()  ;        
}