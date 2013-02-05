/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.guvnor.factmodel.service;

import java.util.Date;

import org.jboss.errai.bus.server.annotations.Remote;
import org.kie.guvnor.commons.service.source.ViewSourceService;
import org.kie.guvnor.commons.service.validation.ValidationService;
import org.kie.guvnor.commons.service.verification.SimpleVerificationService;
import org.kie.guvnor.factmodel.model.FactModelContent;
import org.kie.guvnor.factmodel.model.FactModels;
import org.kie.guvnor.services.config.model.ResourceConfig;
import org.kie.guvnor.services.metadata.model.Metadata;
import org.uberfire.backend.vfs.Path;

@Remote
public interface FactModelService
        extends ViewSourceService<FactModels>,
                ValidationService<FactModels>,
                SimpleVerificationService<FactModels> {

    FactModelContent loadContent( final Path path );

    void save( final Path path,
               final FactModels content,
               final ResourceConfig config,
               final Metadata metadata,
               final String comment );

    void save(final Path path,
              final FactModels factModel,
              final String comment);
    
    void delete( final Path path, String comment );
    
    void rename( final Path path, String newName, String comment );
    
    void copy( final Path path, String newName, String comment );
}
