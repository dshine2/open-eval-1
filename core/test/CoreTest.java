import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.route;
import controllers.Core;

import java.util.ArrayList;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import play.mvc.Result;
import play.test.FakeApplication;
import play.test.Helpers;
import play.test.WithApplication;
import play.twirl.api.Content;

import controllers.Core;
import controllers.DummySolver;
/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class CoreTest extends WithApplication {

	@Override
	protected FakeApplication provideFakeApplication() {
		return new FakeApplication(new java.io.File("."), Helpers.class.getClassLoader(),
			ImmutableMap.of("play.http.router", "router.Routes"), new ArrayList<String>(), null);
	}
    @Test
    public void invalidUrl() {
        String url = "fakeurl:9000";
		String conf_id = "1";
		int status = Core.startJob(conf_id, url);
		assertEquals(404, status);
		DummySolver testSolver = new DummySolver(url);
		status = testSolver.testURL();
		assertEquals(404, status);
    }
}