

public abstract class Command {
	
	abstract public void visit(Visitor visitor) throws Exception;
	
	public boolean isCommandExit(){
		return false;
	} 
	
	public boolean isCommandOffAll(){
		return false;
	}
	
	public boolean isCommandOnAll(){
		return false;
	}
	
	public boolean isCommandOn(){
		return false;
	}
	
	public boolean isCommandOff(){
		return false;
	}
	
	public int getIndex(){
		return -1;
	}
	
    static public interface Visitor {
		
		void visit(Exit cmd) throws Exception;
		void visit(OffAll cmd) throws Exception;
		void visit(OnAll cmd) throws Exception;
		void visit(On cmd) throws Exception;
		void visit(Off cmd) throws Exception;
	}
	
	static public class Off extends Command {

		private int index;

		public Off(int index) {
			super();
			this.index = index;
		}

		public int getIndex() {
			return index;
		}

		@Override
		public boolean isCommandOff() {
			return true;
		}

		@Override
		public void visit(Visitor visitor) throws Exception {
			visitor.visit(this);
			
		}
	}
		
	static public class OffAll extends Command {

			@Override
			public boolean isCommandOffAll() {
				return true;
			}

			@Override
			public void visit(Visitor visitor) throws Exception {
				visitor.visit(this);// TODO Auto-generated method stub
			}

	}
	
	static public class On extends Command {

		private int index;

		public On(int index) {
			super();
			this.index = index;
		}

		public int getIndex() {
			return index;
		}

		@Override
		public boolean isCommandOn() {
			return true;
		}

		@Override
		public void visit(Visitor visitor) throws Exception {
			visitor.visit(this);
		}

	}

	static public class OnAll extends Command {

		@Override
		public boolean isCommandOnAll() {
			return true;
		}

		@Override
		public void visit(Visitor visitor) throws Exception {
			visitor.visit(this);// TODO Auto-generated method stub
		}

	}
	
	static public class Exit extends Command {

		@Override
		public boolean isCommandExit() {
			return true;
		}

		@Override
		public void visit(Visitor visitor) throws Exception {
			visitor.visit(this);
			
		}
	}
	
}
