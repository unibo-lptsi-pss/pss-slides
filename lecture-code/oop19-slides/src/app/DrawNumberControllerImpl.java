package app;

public class DrawNumberControllerImpl implements DrawNumberController {
	
	private static final int MAX_DRAWS = 5;
	
	private final DrawNumberView view;
	private final DrawNumberModel model;
	private int countDraws = 0;
	
	public DrawNumberControllerImpl(DrawNumberView view, DrawNumberModel model) {
		super();
		this.view = view;
		this.model = model;
	}

	@Override
	public void newDraw(int n) {
		final DrawNumberModel.Result result = this.model.draw(n);
		if (result == DrawNumberModel.Result.NOT_IN_RANGE) {
			this.view.notInRange();
			return;
		}
		this.countDraws = this.countDraws + 1;
		if (result == DrawNumberModel.Result.WON) {
			this.view.won();
			System.exit(0);
		}
		if (countDraws == MAX_DRAWS) {
			this.view.outOfMoves();
			System.exit(0);
		}
		if (result == DrawNumberModel.Result.TOO_LOW) {
			this.view.numberTooLow();	
		} else {
			this.view.numberTooHigh();	
		}
	}
}
