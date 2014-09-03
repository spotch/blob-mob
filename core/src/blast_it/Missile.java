package blast_it;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;

public class Missile extends Actor {

	private float _missileMoveSpeed;

	private Texture _texture;

	@Inject
	public Missile(@Named("MissileTexture") Texture texture,
			@Named("MissileWidth") float width,
			@Named("MissileHeight") float height,
			@Named("MissileMoveSpeed") float missileMoveSpeed,
			@Assisted("rotation") float rotation,
			@Assisted("x") float x,
			@Assisted("y") float y) {
		_texture = texture;
		_missileMoveSpeed = missileMoveSpeed;

		setSize(width, height);
		setRotation(rotation);
		setPosition(x, y);
	}

	public void update(float delta) {
		float movementDelta = _missileMoveSpeed * delta;
		float oldX = getX();
		float oldY = getY();
		float rotation = getRotation();
		float rotationRadians = (float) Math.toRadians(rotation + 90);

		float unitX = (float) Math.cos(rotationRadians);
		float unitY = (float) Math.sin(rotationRadians);

		setPosition(oldX + unitX * movementDelta, oldY + unitY * movementDelta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(_texture, getX(), getY(), 64.0f, 64.0f, getWidth(), getHeight(), getScaleX(), getScaleY(),
				getRotation(), 0, 0, 256, 256, false, false);
	}
}
