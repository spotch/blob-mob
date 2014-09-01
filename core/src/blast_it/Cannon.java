package blast_it;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Cannon extends Actor {

	private Texture _texture;

	@Inject
	public Cannon(@Named("CannonTexture") Texture texture) {
		_texture = texture;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(_texture, 10, 10);
	}
}
