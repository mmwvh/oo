/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public enum Fragment {
	NZ, OW, NO, NW, ZO, ZW, KR;

	private Loipe l;
	private Fragment(){
		
	}
	
	/**
	 * 
	 * @param step huidig step
	 * @param d huidige kijk richting
	 * @param loipe de loipe
	 * @return returned het fragment bij de juiste stap en kijkrichting
	 */
	public Fragment makeStep(char step, Direction d, Loipe loipe){
		this.l = loipe;
		switch(d){
		case N:
			if (step == 'r') {
				return Fragment.ZO;

			} else if (step == 'l') {
				return Fragment.ZW;
			} else {
				if (visited()){
					return Fragment.KR;
				}else{
					return Fragment.NZ;
				}			
			}
		case Z:
			if (step == 'r') {
				return Fragment.NW;
			} else if (step == 'l') {
				return Fragment.NO;
			} else {
				if (visited()){
					return Fragment.KR;
				}else{
					return Fragment.NZ;
				}
			}
		case O:
			if (step == 'r') {

				return Fragment.ZW;
			} else if (step == 'l') {

				return Fragment.NW;
			} else {
				if (visited()){
					return Fragment.KR;
				}else{
					return Fragment.OW;
				}
			}
		default:
			if (step == 'r') {

				return Fragment.NO;
			} else if (step == 'l') {
				return Fragment.ZO;
			} else {
				if (visited()){
					return Fragment.KR;
				}else{
					return Fragment.OW;
				}
			}
		}
	}

	/**
	 * 
	 * @return TRUE als er al een fragment in de array loipe op plek xy zit FALSE zo niet
	 */
	private boolean visited() {
		Fragment f = l.getLoipexy();
		if (f != null) {
			return true;
		}
		return false;
	}

}
