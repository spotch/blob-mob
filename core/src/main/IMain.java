package main;

public interface IMain {
	public void create();

	public void resize(int width, int height);

	public void render();

	public void pause();

	public void resume();

	public void dispose();
}
