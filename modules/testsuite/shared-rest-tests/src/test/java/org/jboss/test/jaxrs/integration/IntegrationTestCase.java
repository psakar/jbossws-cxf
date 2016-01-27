/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2016, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.test.jaxrs.integration;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.ext.RuntimeDelegate;

import org.apache.cxf.BusFactory;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.wsf.test.JBossWSTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author <a href="mailto:alessio.soldano@jboss.com">Alessio Soldano</a>
 */
@RunWith(Arquillian.class)
//TODO move this class away from the shared REST testsuite to a CXF REST testsuite
public class IntegrationTestCase extends JBossWSTest
{
   @Test
   @RunAsClient
   public void testBusIntegration() throws Exception {
      BusFactory b = BusFactory.newInstance();
      Assert.assertEquals("org.jboss.wsf.stack.cxf.client.configuration.JBossWSBusFactory", b.getClass().getName());
   }
   
   @Test
   @RunAsClient
   public void testClientBuilderIntegration() throws Exception {
      ClientBuilder b = ClientBuilder.newBuilder();
      Assert.assertEquals("org.apache.cxf.jaxrs.client.spec.ClientBuilderImpl", b.getClass().getName());
   }
   
   @Test
   @RunAsClient
   public void testRuntimeDelegateIntegration() throws Exception {
      RuntimeDelegate b = RuntimeDelegate.getInstance();
      Assert.assertEquals("org.apache.cxf.jaxrs.impl.RuntimeDelegateImpl", b.getClass().getName());
   }
}
