package naval.gabriel.platformer.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import naval.gabriel.platformer.rendering.textures.Sprite;
import naval.gabriel.platformer.states.GameState;

/* Entity
 * Abstract class representing characters on the screen
 * 
 */

public abstract class Entity {

	protected double x, y;
	protected Sprite sprite;
	protected GameState state;
	 
	
	public Entity(Sprite sprite, double x, double y, GameState state) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		this.state= state;
		state.addEntity(this);
	} 
	
	public abstract void tick();
	
	public void render(Graphics2D g) {
		sprite.render(g, x, y);
		g.setColor(Color.RED);
		g.draw(getTop());
		g.setColor(Color.BLUE);
		g.draw(getBottom());
		g.setColor(Color.MAGENTA);
		g.draw(getLeft());
		g.setColor(Color.ORANGE);
		g.draw(getRight());
	}
	
	public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, sprite.getWidth(),
                sprite.getHeight());
    }

    public Rectangle getTop() {
        return new Rectangle((int) x + 6, (int) y, sprite.getWidth() - 6, 4);
    }

    public Rectangle getBottom() {
        return new Rectangle((int) x + 6, (int)y + sprite.getHeight() - 4,
                sprite.getWidth() - 6, 4);
    }

    public Rectangle getRight() {
        return new Rectangle((int) x + sprite.getWidth() - 4, (int) y + 6, 4,
                sprite.getHeight() - 6);
    }

    public Rectangle getLeft() {
        return new Rectangle((int) x, (int) y + 6, 4,
                sprite.getHeight() - 6);
    }
	
}
