package app;

public class DrawNumberApplication {

	public static void main(String[] args) {
		DrawNumberModel model = new DrawNumberModelImpl();
		DrawNumberView view = new DrawNumberViewImpl();
		DrawNumberController controller = new DrawNumberControllerImpl(view,model);
		view.addController(controller);
	}

}
