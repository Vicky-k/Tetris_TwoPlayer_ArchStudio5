package edu.umkc.tetris5;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;



public class TetrisImp extends JFrame implements ITetrisImp
{
private TetrisArch _arch;
	
	/**
	 * The Serial Version UID.
	 */
	public static final long serialVersionUID = -4722429764792514382L;

	/**
	 * The number of milliseconds per frame.
	 */
	public static final long FRAME_TIME = 1000L / 50L;
	
	/**
	 * The number of pieces that exist.
	 */
	public static final int TYPE_COUNT = TileType.values().length;
		
	/**
	 * The BoardPanel instance.
	 */
	public BoardPanelOne boardOne;
	
	/**
	 * The SidePanel instance.
	 */
	public SidePanelOne sideOne;
	
	/**
	 * Whether or not the game is paused.
	 */
	public boolean isPausedOne;
	
	/**
	 * Whether or not we've played a game yet. This is set to true
	 * initially and then set to false when the game starts.
	 */
	public boolean isNewGameOne;
	
	/**
	 * Whether or not the game is over.
	 */
	public boolean isGameOverOne;
	
	/**
	 * The current level we're on.
	 */
	public int levelOne;
	
	/**
	 * The current score.
	 */
	public int scoreOne;
	
	/**
	 * The random number generator. This is used to
	 * spit out pieces randomly.
	 */
	public Random random;
	
	/**
	 * The clock that handles the update logic.
	 */
	//public Clock logicTimer;
				
	/**
	 * The current type of tile.
	 */
	public TileType currentTypeOne;
	
	/**
	 * The next type of tile.
	 */
	public TileType nextTypeOne;
		
	/**
	 * The current column of our tile.
	 */
	public int currentColOne;
	
	/**
	 * The current row of our tile.
	 */
	public int currentRowOne;
	
	/**
	 * The current rotation of our tile.
	 */
	public int currentRotationOne;
		
	/**
	 * Ensures that a certain amount of time passes after a piece is
	 * spawned before we can drop it.
	 */
	public int dropCooldownOne;
	
	/**
	 * The speed of the game.
	 */
	public float gameSpeedOne;
		
	/**
	 * Creates a new Tetris instance. Sets up the window's properties,
	 * and adds a controller listener.
	 */
	// End of Game one variables  and next start of Game two variables
	
	/**
	 * The BoardPanel instance.
	 */
	public BoardPanelTwo boardTwo;
	
	/**
	 * The SidePanel instance.
	 */
	public SidePanelTwo sideTwo;
	
	/**
	 * Whether or not the game is paused.
	 */
	public boolean isPausedTwo;
	
	/**
	 * Whether or not we've played a game yet. This is set to true
	 * initially and then set to false when the game starts.
	 */
	public boolean isNewGameTwo;
	
	/**
	 * Whether or not the game is over.
	 */
	public boolean isGameOverTwo;
	
	/**
	 * The current level we're on.
	 */
	public int levelTwo;
	
	/**
	 * The current score.
	 */
	public int scoreTwo;
	
	/**
	 * The random number generator. This is used to
	 * spit out pieces randomly.
	 */
	//public Random random;
	
	/**
	 * The clock that handles the update logic.
	 */
	//public Clock logicTimer;
				
	/**
	 * The current type of tile.
	 */
	public TileType currentTypeTwo;
	
	/**
	 * The next type of tile.
	 */
	public TileType nextTypeTwo;
		
	/**
	 * The current column of our tile.
	 */
	public int currentColTwo;
	
	/**
	 * The current row of our tile.
	 */
	public int currentRowTwo;
	
	/**
	 * The current rotation of our tile.
	 */
	public int currentRotationTwo;
		
	/**
	 * Ensures that a certain amount of time passes after a piece is
	 * spawned before we can drop it.
	 */
	public int dropCooldownTwo;
	
	/**
	 * The speed of the game.
	 */
	public float gameSpeedTwo;

	

    public TetrisImp (){
    }

	public void setArch(TetrisArch arch){
		_arch = arch;
	}
	public TetrisArch getArch(){
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
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(new GridLayout(1,4));
		
		/*
		 * Initialize the BoardPanel and SidePanel instances.
		 */
		this.boardOne = new BoardPanelOne(this);
		this.sideOne = new SidePanelOne(this);
		
		/*
		 * Add the BoardPanel and SidePanel instances to the window.
		 */
		//add(boardOne, BorderLayout.WEST);
		//add(sideOne, BorderLayout.CENTER);
		add(boardOne);
		add(sideOne);
		
		/*
		 * Adds a custom anonymous KeyListener to the frame.
		 */
	
		
		/*
		 * Here we resize the frame to hold the BoardPanel and SidePanel instances,
		 * center the window on the screen, and show it to the user.
		 */
		
		// End of Game one initialization next start of Game two initialization
		
		this.boardTwo = new BoardPanelTwo(this);
		this.sideTwo = new SidePanelTwo(this);
		
		/*
		 * Add the BoardPanel and SidePanel instances to the window.
		 */
		//add(boardTwo, BorderLayout.EAST);
		//add(sideTwo, BorderLayout.SOUTH);
		add(sideTwo);
		add(boardTwo);
		
		/*
		 * Adds a custom anonymous KeyListener to the frame.
		 */
		
		
		/*
		 * Here we resize the frame to hold the BoardPanel and SidePanel instances,
		 * center the window on the screen, and show it to the user.
		 */
		
	addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
								
				switch(e.getKeyCode()) {
				
				/*
				 * Drop - When pressed, we check to see that the game is not
				 * paused and that there is no drop cooldown, then set the
				 * logic timer to run at a speed of 25 cycles per second.
				 */
				case KeyEvent.VK_S:
					if(!isPausedOne && dropCooldownOne == 0) {
						_arch.OUT_ClockOneinterface.setCyclesPerSecond(25.0f);
					}
					break;
					
				/*
				 * Move Left - When pressed, we check to see that the game is
				 * not paused and that the position to the left of the current
				 * position is valid. If so, we decrement the current column by 1.
				 */
				case KeyEvent.VK_A:
					if(!isPausedOne && boardOne.isValidAndEmpty(currentTypeOne, currentColOne - 1, currentRowOne, currentRotationOne)) {
						currentColOne--;
					}
					break;
					
				/*
				 * Move Right - When pressed, we check to see that the game is
				 * not paused and that the position to the right of the current
				 * position is valid. If so, we increment the current column by 1.
				 */
				case KeyEvent.VK_D:
					if(!isPausedOne && boardOne.isValidAndEmpty(currentTypeOne, currentColOne + 1, currentRowOne, currentRotationOne)) {
						currentColOne++;
					}
					break;
					
				/*
				 * Rotate Anticlockwise - When pressed, check to see that the game is not paused
				 * and then attempt to rotate the piece anticlockwise. Because of the size and
				 * complexity of the rotation code, as well as it's similarity to clockwise
				 * rotation, the code for rotating the piece is handled in another method.
				 */
				case KeyEvent.VK_Q:
					if(!isPausedOne) {
						rotatePiece((currentRotationOne == 0) ? 3 : currentRotationOne - 1);
					}
					break;
				
				/*
			     * Rotate Clockwise - When pressed, check to see that the game is not paused
				 * and then attempt to rotate the piece clockwise. Because of the size and
				 * complexity of the rotation code, as well as it's similarity to anticlockwise
				 * rotation, the code for rotating the piece is handled in another method.
				 */
				case KeyEvent.VK_E:
					if(!isPausedOne) {
						rotatePiece((currentRotationOne == 3) ? 0 : currentRotationOne + 1);
					}
					break;
					
				/*
				 * Pause Game - When pressed, check to see that we're currently playing a game.
				 * If so, toggle the pause variable and update the logic timer to reflect this
				 * change, otherwise the game will execute a huge number of updates and essentially
				 * cause an instant game over when we unpause if we stay paused for more than a
				 * minute or so.
				 */
				case KeyEvent.VK_P:
					if(!isGameOverOne && !isNewGameOne) {
						isPausedOne = !isPausedOne;
						_arch.OUT_ClockOneinterface.setPaused(isPausedOne);
					}
					break;
				
				/*
				 * Start Game - When pressed, check to see that we're in either a game over or new
				 * game state. If so, reset the game.
				 */
				case KeyEvent.VK_ENTER:
					if(isGameOverOne || isNewGameOne) {
						resetGame();
					}
					break;
					
				case KeyEvent.VK_Z:
					if(!isPausedTwo && dropCooldownTwo == 0) {
						_arch.OUT_ClockTwointerface.setCyclesPerSecond(25.0f);
					}
					break;
					
				/*
				 * Move Left - When pressed, we check to see that the game is
				 * not paused and that the position to the left of the current
				 * position is valid. If so, we decrement the current column by 1.
				 */
				case KeyEvent.VK_X:
					if(!isPausedTwo && boardTwo.isValidAndEmpty(currentTypeTwo, currentColTwo - 1, currentRowTwo, currentRotationTwo)) {
						currentColTwo--;
					}
					break;
					
				/*
				 * Move Right - When pressed, we check to see that the game is
				 * not paused and that the position to the right of the current
				 * position is valid. If so, we increment the current column by 1.
				 */
				case KeyEvent.VK_C:
					if(!isPausedTwo && boardTwo.isValidAndEmpty(currentTypeTwo, currentColTwo + 1, currentRowTwo, currentRotationTwo)) {
						currentColTwo++;
					}
					break;
					
				/*
				 * Rotate Anticlockwise - When pressed, check to see that the game is not paused
				 * and then attempt to rotate the piece anticlockwise. Because of the size and
				 * complexity of the rotation code, as well as it's similarity to clockwise
				 * rotation, the code for rotating the piece is handled in another method.
				 */
				case KeyEvent.VK_V:
					if(!isPausedTwo) {
						rotatePiece2((currentRotationTwo == 0) ? 3 : currentRotationTwo - 1);
					}
					break;
				
				/*
			     * Rotate Clockwise - When pressed, check to see that the game is not paused
				 * and then attempt to rotate the piece clockwise. Because of the size and
				 * complexity of the rotation code, as well as it's similarity to anticlockwise
				 * rotation, the code for rotating the piece is handled in another method.
				 */
				case KeyEvent.VK_B:
					if(!isPausedTwo) {
						rotatePiece2((currentRotationTwo == 3) ? 0 : currentRotationTwo + 1);
					}
					break;
					
				/*
				 * Pause Game - When pressed, check to see that we're currently playing a game.
				 * If so, toggle the pause variable and update the logic timer to reflect this
				 * change, otherwise the game will execute a huge number of updates and essentially
				 * cause an instant game over when we unpause if we stay paused for more than a
				 * minute or so.
				 */
				case KeyEvent.VK_N:
					if(!isGameOverTwo && !isNewGameTwo) {
						isPausedTwo = !isPausedTwo;
						_arch.OUT_ClockTwointerface.setPaused(isPausedTwo);
					}
					break;
				
				/*
				 * Start Game - When pressed, check to see that we're in either a game over or new
				 * game state. If so, reset the game.
				 */
				case KeyEvent.VK_ALT:
					if(isGameOverTwo || isNewGameTwo) {
						resetGame2();
					}
					break;
				
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				switch(e.getKeyCode()) {
				
				/*
				 * Drop - When released, we set the speed of the logic timer
				 * back to whatever the current game speed is and clear out
				 * any cycles that might still be elapsed.
				 */
				case KeyEvent.VK_S:
					_arch.OUT_ClockOneinterface.setCyclesPerSecond(gameSpeedOne);
					_arch.OUT_ClockOneinterface.reset();
					break;
					
				case KeyEvent.VK_Z:
					_arch.OUT_ClockTwointerface.setCyclesPerSecond(gameSpeedTwo);
					_arch.OUT_ClockTwointerface.reset();
					break;
				}
				
			}
			
		});
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		//startGame2();
		startGame();
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
	/**
	 * Starts the game running. Initializes everything and enters the game loop.
	 */
	public void startGame() {
		/*
		 * Initialize our random number generator, logic timer, and new game variables.
		 */
		this.random = new Random();
		this.isNewGameOne = true;
		this.gameSpeedOne = 1.0f;
		
		/*
		 * Setup the timer to keep the game from running before the user presses enter
		 * to start it.
		 */
		//this.logicTimer = new Clock(gameSpeed);
		_arch.OUT_ClockOneinterface.initialize(gameSpeedOne);
		_arch.OUT_ClockOneinterface.setPaused(true);
		
		
		// Game two startgame initialization
		
		this.random = new Random();
		this.isNewGameTwo = true;
		this.gameSpeedTwo = 1.0f;
		
		/*
		 * Setup the timer to keep the game from running before the user presses enter
		 * to start it.
		 */
		//this.logicTimer = new Clock(gameSpeed);
		_arch.OUT_ClockTwointerface.initialize(gameSpeedTwo);
		_arch.OUT_ClockTwointerface.setPaused(true);
		
		while(true) {
			//Get the time that the frame started.
			long start = System.nanoTime();
			
			//Update the logic timer.
			_arch.OUT_ClockOneinterface.update();
			
			/*
			 * If a cycle has elapsed on the timer, we can update the game and
			 * move our current piece down.
			 */
			if(_arch.OUT_ClockOneinterface.hasElapsedCycle()) {
				updateGame();
			}
		
			//Decrement the drop cool down if necessary.
			if(dropCooldownOne > 0) {
				dropCooldownOne--;
			}
			
			//Display the window to the user.
			renderGame();
			
			//Update the logic timer.
			_arch.OUT_ClockTwointerface.update();
			
			/*
			 * If a cycle has elapsed on the timer, we can update the game and
			 * move our current piece down.
			 */
			if(_arch.OUT_ClockTwointerface.hasElapsedCycle()) {
				updateGame2();
			}
		
			//Decrement the drop cool down if necessary.
			if(dropCooldownTwo > 0) {
				dropCooldownTwo--;
			}
			
			//Display the window to the user.
			renderGame2();
			
			/*
			 * Sleep to cap the framerate.
			 */
			long delta = (System.nanoTime() - start) / 1000000L;
			if(delta < FRAME_TIME) {
				try {
					Thread.sleep(FRAME_TIME - delta);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Updates the game and handles the bulk of it's logic.
	 */
	public void updateGame() {
		/*
		 * Check to see if the piece's position can move down to the next row.
		 */
		if(boardOne.isValidAndEmpty(currentTypeOne, currentColOne, currentRowOne + 1, currentRotationOne)) {
			//Increment the current row if it's safe to do so.
			currentRowOne++;
		} else {
			/*
			 * We've either reached the bottom of the board, or landed on another piece, so
			 * we need to add the piece to the board.
			 */
			boardOne.addPiece(currentTypeOne, currentColOne, currentRowOne, currentRotationOne);
			
			/*
			 * Check to see if adding the new piece resulted in any cleared lines. If so,
			 * increase the player's score. (Up to 4 lines can be cleared in a single go;
			 * [1 = 100pts, 2 = 200pts, 3 = 400pts, 4 = 800pts]).
			 */
			int cleared = boardOne.checkLines(boardTwo);
			if(cleared > 0) {
				scoreOne += 50 << cleared;
			}
			
			/*
			 * Increase the speed slightly for the next piece and update the game's timer
			 * to reflect the increase.
			 */
			gameSpeedOne += 0.035f;
			_arch.OUT_ClockOneinterface.setCyclesPerSecond(gameSpeedOne);
			_arch.OUT_ClockOneinterface.reset();
			
			/*
			 * Set the drop cooldown so the next piece doesn't automatically come flying
			 * in from the heavens immediately after this piece hits if we've not reacted
			 * yet. (~0.5 second buffer).
			 */
			dropCooldownOne = 25;
			
			/*
			 * Update the difficulty level. This has no effect on the game, and is only
			 * used in the "Level" string in the SidePanel.
			 */
			levelOne = (int)(gameSpeedOne * 1.70f);
			
			/*
			 * Spawn a new piece to control.
			 */
			spawnPiece();
		}		
	}
	
	/**
	 * Forces the BoardPanel and SidePanel to repaint.
	 */
	public void renderGame() {
		boardOne.repaint();
		sideOne.repaint();
	}
	
	/**
	 * Resets the game variables to their default values at the start
	 * of a new game.
	 */
	public void resetGame() {
		this.levelOne = 1;
		this.scoreOne = 0;
		this.gameSpeedOne = 1.0f;
		this.nextTypeOne = TileType.values()[random.nextInt(TYPE_COUNT)];
		this.isNewGameOne = false;
		this.isGameOverOne = false;		
		boardOne.clear();
		_arch.OUT_ClockOneinterface.reset();
		_arch.OUT_ClockOneinterface.setCyclesPerSecond(gameSpeedOne);
		spawnPiece();
	}
		
	/**
	 * Spawns a new piece and resets our piece's variables to their default
	 * values.
	 */
	public void spawnPiece() {
		/*
		 * Poll the last piece and reset our position and rotation to
		 * their default variables, then pick the next piece to use.
		 */
		this.currentTypeOne = nextTypeOne;
		this.currentColOne = currentTypeOne.getSpawnColumn();
		this.currentRowOne = currentTypeOne.getSpawnRow();
		this.currentRotationOne = 0;
		this.nextTypeOne = TileType.values()[random.nextInt(TYPE_COUNT)];
		
		/*
		 * If the spawn point is invalid, we need to pause the game and flag that we've lost
		 * because it means that the pieces on the board have gotten too high.
		 */
		if(!boardOne.isValidAndEmpty(currentTypeOne, currentColOne, currentRowOne, currentRotationOne)) {
			this.isGameOverOne = true;
			_arch.OUT_Controllerintf.result("player2");
			_arch.OUT_ClockOneinterface.setPaused(true);
			this.isGameOverTwo = true;
		}		
	}

	/**
	 * Attempts to set the rotation of the current piece to newRotation.
	 * @param newRotation The rotation of the new peice.
	 */
	public void rotatePiece(int newRotation) {
		/*
		 * Sometimes pieces will need to be moved when rotated to avoid clipping
		 * out of the board (the I piece is a good example of this). Here we store
		 * a temporary row and column in case we need to move the tile as well.
		 */
		int newColumn = currentColOne;
		int newRow = currentRowOne;
		
		/*
		 * Get the insets for each of the sides. These are used to determine how
		 * many empty rows or columns there are on a given side.
		 */
		int left = currentTypeOne.getLeftInset(newRotation);
		int right = currentTypeOne.getRightInset(newRotation);
		int top = currentTypeOne.getTopInset(newRotation);
		int bottom = currentTypeOne.getBottomInset(newRotation);
		
		/*
		 * If the current piece is too far to the left or right, move the piece away from the edges
		 * so that the piece doesn't clip out of the map and automatically become invalid.
		 */
		if(currentColOne < -left) {
			newColumn -= currentColOne - left;
		} else if(currentColOne + currentTypeOne.getDimension() - right >= BoardPanelOne.COL_COUNT) {
			newColumn -= (currentColOne + currentTypeOne.getDimension() - right) - BoardPanelOne.COL_COUNT + 1;
		}
		
		/*
		 * If the current piece is too far to the top or bottom, move the piece away from the edges
		 * so that the piece doesn't clip out of the map and automatically become invalid.
		 */
		if(currentRowOne < -top) {
			newRow -= currentRowOne - top;
		} else if(currentRowOne + currentTypeOne.getDimension() - bottom >= BoardPanelOne.ROW_COUNT) {
			newRow -= (currentRowOne + currentTypeOne.getDimension() - bottom) - BoardPanelOne.ROW_COUNT + 1;
		}
		
		/*
		 * Check to see if the new position is acceptable. If it is, update the rotation and
		 * position of the piece.
		 */
		if(boardOne.isValidAndEmpty(currentTypeOne, newColumn, newRow, newRotation)) {
			currentRotationOne = newRotation;
			currentRowOne = newRow;
			currentColOne = newColumn;
		}
	}
	
	/**
	 * Checks to see whether or not the game is paused.
	 * @return Whether or not the game is paused.
	 */
	public boolean isPaused() {
		return isPausedOne;
	}
	
	/**
	 * Checks to see whether or not the game is over.
	 * @return Whether or not the game is over.
	 */
	public boolean isGameOver() {
		return isGameOverOne;
	}
	
	/**
	 * Checks to see whether or not we're on a new game.
	 * @return Whether or not this is a new game.
	 */
	public boolean isNewGame() {
		return isNewGameOne;
	}
	
	/**
	 * Gets the current score.
	 * @return The score.
	 */
	public int getScore() {
		return scoreOne;
	}
	
	/**
	 * Gets the current level.
	 * @return The level.
	 */
	public int getLevel() {
		return levelOne;
	}
	
	/**
	 * Gets the current type of piece we're using.
	 * @return The piece type.
	 */
	public TileType getPieceType() {
		return currentTypeOne;
	}
	
	/**
	 * Gets the next type of piece we're using.
	 * @return The next piece.
	 */
	public TileType getNextPieceType() {
		return nextTypeOne;
	}
	
	/**
	 * Gets the column of the current piece.
	 * @return The column.
	 */
	public int getPieceCol() {
		return currentColOne;
	}
	
	/**
	 * Gets the row of the current piece.
	 * @return The row.
	 */
	public int getPieceRow() {
		return currentRowOne;
	}
	
	/**
	 * Gets the rotation of the current piece.
	 * @return The rotation.
	 */
	public int getPieceRotation() {
		return currentRotationOne;
	}

	/**
	 * Entry-point of the game. Responsible for creating and starting a new
	 * game instance.
	 * @param args Unused.
	 */
	
	// End of methods of Game one next start of Game Two methods
	
	
	

	
	/**
	 * Updates the game and handles the bulk of it's logic.
	 */
	public void updateGame2() {
		/*
		 * Check to see if the piece's position can move down to the next row.
		 */
		if(boardTwo.isValidAndEmpty(currentTypeTwo, currentColTwo, currentRowTwo + 1, currentRotationTwo)) {
			//Increment the current row if it's safe to do so.
			currentRowTwo++;
		} else {
			/*
			 * We've either reached the bottom of the board, or landed on another piece, so
			 * we need to add the piece to the board.
			 */
			boardTwo.addPiece(currentTypeTwo, currentColTwo, currentRowTwo, currentRotationTwo);
			
			/*
			 * Check to see if adding the new piece resulted in any cleared lines. If so,
			 * increase the player's score. (Up to 4 lines can be cleared in a single go;
			 * [1 = 100pts, 2 = 200pts, 3 = 400pts, 4 = 800pts]).
			 */
			int cleared = boardTwo.checkLines(boardOne);
			if(cleared > 0) {
				scoreTwo += 50 << cleared;
			}
			
			/*
			 * Increase the speed slightly for the next piece and update the game's timer
			 * to reflect the increase.
			 */
			gameSpeedTwo += 0.035f;
			_arch.OUT_ClockTwointerface.setCyclesPerSecond(gameSpeedTwo);
			_arch.OUT_ClockTwointerface.reset();
			
			/*
			 * Set the drop cooldown so the next piece doesn't automatically come flying
			 * in from the heavens immediately after this piece hits if we've not reacted
			 * yet. (~0.5 second buffer).
			 */
			dropCooldownTwo = 25;
			
			/*
			 * Update the difficulty level. This has no effect on the game, and is only
			 * used in the "Level" string in the SidePanel.
			 */
			levelTwo = (int)(gameSpeedTwo * 1.70f);
			
			/*
			 * Spawn a new piece to control.
			 */
			spawnPiece2();
		}		
	}
	
	/**
	 * Forces the BoardPanel and SidePanel to repaint.
	 */
	public void renderGame2() {
		boardTwo.repaint();
		sideTwo.repaint();
	}
	
	/**
	 * Resets the game variables to their default values at the start
	 * of a new game.
	 */
	public void resetGame2() {
		this.levelTwo = 1;
		this.scoreTwo = 0;
		this.gameSpeedTwo = 1.0f;
		this.nextTypeTwo = TileType.values()[random.nextInt(TYPE_COUNT)];
		this.isNewGameTwo = false;
		this.isGameOverTwo = false;		
		boardTwo.clear();
		_arch.OUT_ClockTwointerface.reset();
		_arch.OUT_ClockTwointerface.setCyclesPerSecond(gameSpeedTwo);
		spawnPiece2();
	}
		
	/**
	 * Spawns a new piece and resets our piece's variables to their default
	 * values.
	 */
	public void spawnPiece2() {
		/*
		 * Poll the last piece and reset our position and rotation to
		 * their default variables, then pick the next piece to use.
		 */
		this.currentTypeTwo = nextTypeTwo;
		this.currentColTwo = currentTypeTwo.getSpawnColumn();
		this.currentRowTwo = currentTypeTwo.getSpawnRow();
		this.currentRotationTwo = 0;
		this.nextTypeTwo = TileType.values()[random.nextInt(TYPE_COUNT)];
		
		/*
		 * If the spawn point is invalid, we need to pause the game and flag that we've lost
		 * because it means that the pieces on the board have gotten too high.
		 */
		if(!boardTwo.isValidAndEmpty(currentTypeTwo, currentColTwo, currentRowTwo, currentRotationTwo)) {
			this.isGameOverTwo = true;
			_arch.OUT_Controllerintf.result("player1");
			_arch.OUT_ClockTwointerface.setPaused(true);
			this.isGameOverOne = true;
		}		
	}

	/**
	 * Attempts to set the rotation of the current piece to newRotation.
	 * @param newRotation The rotation of the new peice.
	 */
	public void rotatePiece2(int newRotation) {
		/*
		 * Sometimes pieces will need to be moved when rotated to avoid clipping
		 * out of the board (the I piece is a good example of this). Here we store
		 * a temporary row and column in case we need to move the tile as well.
		 */
		int newColumn = currentColTwo;
		int newRow = currentRowTwo;
		
		/*
		 * Get the insets for each of the sides. These are used to determine how
		 * many empty rows or columns there are on a given side.
		 */
		int left = currentTypeTwo.getLeftInset(newRotation);
		int right = currentTypeTwo.getRightInset(newRotation);
		int top = currentTypeTwo.getTopInset(newRotation);
		int bottom = currentTypeTwo.getBottomInset(newRotation);
		
		/*
		 * If the current piece is too far to the left or right, move the piece away from the edges
		 * so that the piece doesn't clip out of the map and automatically become invalid.
		 */
		if(currentColTwo < -left) {
			newColumn -= currentColTwo - left;
		} else if(currentColTwo + currentTypeTwo.getDimension() - right >= BoardPanelTwo.COL_COUNT) {
			newColumn -= (currentColTwo + currentTypeTwo.getDimension() - right) - BoardPanelTwo.COL_COUNT + 1;
		}
		
		/*
		 * If the current piece is too far to the top or bottom, move the piece away from the edges
		 * so that the piece doesn't clip out of the map and automatically become invalid.
		 */
		if(currentRowTwo < -top) {
			newRow -= currentRowTwo - top;
		} else if(currentRowTwo + currentTypeTwo.getDimension() - bottom >= BoardPanelTwo.ROW_COUNT) {
			newRow -= (currentRowTwo + currentTypeTwo.getDimension() - bottom) - BoardPanelTwo.ROW_COUNT + 1;
		}
		
		/*
		 * Check to see if the new position is acceptable. If it is, update the rotation and
		 * position of the piece.
		 */
		if(boardTwo.isValidAndEmpty(currentTypeTwo, newColumn, newRow, newRotation)) {
			currentRotationTwo = newRotation;
			currentRowTwo = newRow;
			currentColTwo = newColumn;
		}
	}
	
	/**
	 * Checks to see whether or not the game is paused.
	 * @return Whether or not the game is paused.
	 */
	public boolean isPaused2() {
		return isPausedTwo;
	}
	
	/**
	 * Checks to see whether or not the game is over.
	 * @return Whether or not the game is over.
	 */
	public boolean isGameOver2() {
		return isGameOverTwo;
	}
	
	/**
	 * Checks to see whether or not we're on a new game.
	 * @return Whether or not this is a new game.
	 */
	public boolean isNewGame2() {
		return isNewGameTwo;
	}
	
	/**
	 * Gets the current score.
	 * @return The score.
	 */
	public int getScore2() {
		return scoreTwo;
	}
	
	/**
	 * Gets the current level.
	 * @return The level.
	 */
	public int getLevel2() {
		return levelTwo;
	}
	
	/**
	 * Gets the current type of piece we're using.
	 * @return The piece type.
	 */
	public TileType getPieceType2() {
		return currentTypeTwo;
	}
	
	/**
	 * Gets the next type of piece we're using.
	 * @return The next piece.
	 */
	public TileType getNextPieceType2() {
		return nextTypeTwo;
	}
	
	/**
	 * Gets the column of the current piece.
	 * @return The column.
	 */
	public int getPieceCol2() {
		return currentColTwo;
	}
	
	/**
	 * Gets the row of the current piece.
	 * @return The row.
	 */
	public int getPieceRow2() {
		return currentRowTwo;
	}
	
	/**
	 * Gets the rotation of the current piece.
	 * @return The rotation.
	 */
	public int getPieceRotation2() {
		return currentRotationTwo;
	}
}