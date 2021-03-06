/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.esaudemetadata.api.impl;

import org.openmrs.Person;
import org.openmrs.PersonName;
import org.openmrs.Role;
import org.openmrs.User;
import org.openmrs.api.PersonService;
import org.openmrs.api.UserService;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.esaudemetadata.api.EsaudeMetaDataService;
import org.openmrs.module.esaudemetadata.api.db.EsaudeMetaDataServiceDAO;

import java.util.Date;

/**
 * It is a default implementation of {@link EsaudeMetaDataService}.
 */
public class EsaudeMetaDataServiceImpl extends BaseOpenmrsService implements EsaudeMetaDataService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private EsaudeMetaDataServiceDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(EsaudeMetaDataServiceDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public EsaudeMetaDataServiceDAO getDao() {
	    return dao;
    }

    @Override
    public void setDefaultMetadataUser() {
        UserService userService = Context.getUserService();
        if(userService.getUserByUsername("esaude.metadata") != null) {
            log.info("The user `esaude.metadata` exists! with role "+userService.getAllRoles().get(0)+" Use this user for all metadata creation. ");
        }

    }
}