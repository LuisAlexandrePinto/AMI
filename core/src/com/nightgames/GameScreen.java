package com.nightgames;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen, InputProcessor {
    Camera camera;
    SpriteBatch batch;
    private float elapsedTime = 0f;
    Scrollable img;

    public GameScreen() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.viewportHeight = Gdx.graphics.getHeight();
        camera.viewportWidth = Gdx.graphics.getWidth();
        camera.position.set(camera.viewportWidth * .5f, camera.viewportHeight * .5f, 0f);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        img = new Scrollable(0 - AssetLoader.img.getWidth(), Gdx.graphics.getHeight() / 2 -  AssetLoader.img.getHeight() / 2,
                AssetLoader.img.getWidth(), AssetLoader.img.getHeight(), 50f);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        elapsedTime += delta;
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(1, 0, 0, 1);

        img.update(delta);
        if (img.isScrolledDown())
            img.reset(0 - AssetLoader.img.getWidth());

        batch.begin();
        batch.draw(AssetLoader.img, img.getX(), img.getY());
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        // dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
