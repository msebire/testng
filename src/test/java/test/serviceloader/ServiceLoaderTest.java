package test.serviceloader;

import org.testng.TestNG;
import org.testng.annotations.Test;

import test.SimpleBaseTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import junit.framework.Assert;

public class ServiceLoaderTest extends SimpleBaseTest {

  @Test
  public void serviceLoaderShouldWork() throws MalformedURLException {
    TestNG tng = create(ServiceLoaderSampleTest.class);
    URL url = getClass().getClassLoader().getResource("serviceloader.jar");
    URLClassLoader ucl = URLClassLoader.newInstance(new URL[] { url });
    tng.setServiceLoaderClassLoader(ucl);
    tng.run();

    Assert.assertEquals(1, tng.getServiceLoaderListeners().size());
  }
}
