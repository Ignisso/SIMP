public abstract class Effect {
	private JLayer active;
	
	public Effect(JLayer layer) {
		this.active = layer;
		this.doEffect();
	}
	
	public void doEffect();
}