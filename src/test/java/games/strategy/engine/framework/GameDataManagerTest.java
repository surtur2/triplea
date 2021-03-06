package games.strategy.engine.framework;

import games.strategy.engine.data.GameData;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GameDataManagerTest {

  @Test
  public void testLoadStoreKeepsGamUUID() throws IOException {
    final GameData data = new GameData();
    final GameDataManager m = new GameDataManager();
    final ByteArrayOutputStream sink = new ByteArrayOutputStream();
    m.saveGame(sink, data);
    final GameData loaded = m.loadGame(new ByteArrayInputStream(sink.toByteArray()), null);
    assertEquals(loaded.getProperties().get(GameData.GAME_UUID), data.getProperties().get(GameData.GAME_UUID));
  }
}
