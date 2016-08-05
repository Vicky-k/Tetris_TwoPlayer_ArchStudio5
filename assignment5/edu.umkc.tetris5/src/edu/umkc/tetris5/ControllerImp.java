package edu.umkc.tetris5;

import javax.swing.JOptionPane;

public class ControllerImp implements IControllerImp
{
	private ControllerArch _arch;

    public ControllerImp (){
    }

	public void setArch(ControllerArch arch){
		_arch = arch;
	}
	public ControllerArch getArch(){
		return _arch;
	}

	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init(){
	    //TODO Auto-generated method stub
	}
	public void begin(){
		//TODO Auto-generated method stub
	}
	public void end(){
		//TODO Auto-generated method stub
	}
	public void destroy(){
		//TODO Auto-generated method stub
	}

	/*
  	  Implementation primitives required by the architecture
	*/
  
    
    public void result (String player)   {
		//TODO Auto-generated method stub
    	if(player == "player1")
		{
			
			JOptionPane.showMessageDialog(null, "Player1 has won the game");
		}
		if(player == "player2"){
			
			JOptionPane.showMessageDialog(null, "Player2 has won the game");
		}
    }
}