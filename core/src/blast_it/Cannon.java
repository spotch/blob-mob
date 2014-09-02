package blast_it;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Cannon extends Actor {

	private Texture _texture;

	Float _width, _height;

	@Inject
	public Cannon(@Named("CannonTexture") Texture texture,
			@Named("CannonWidth") float width,
			@Named("CannonHeight") float height) {
		_texture = texture;
		_width = width;
		_height = height;

		setSize(_width, _height);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(_texture, getX(), getY(), 64.0f, 64.0f, getWidth(), getHeight(), getScaleX(),
				getScaleY(), getRotation(), 0, 0, 256, 256, false, false);
	}
}
