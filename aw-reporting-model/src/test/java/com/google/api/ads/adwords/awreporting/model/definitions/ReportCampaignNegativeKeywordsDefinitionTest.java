// Copyright 2013 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.awreporting.model.definitions;

import com.google.api.ads.adwords.awreporting.model.entities.ReportCampaignNegativeKeywords;
import com.google.api.ads.adwords.lib.jaxb.v201603.ReportDefinitionReportType;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests the Negative Keywords Performance report definition.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aw-report-sql-beans.xml")
@ActiveProfiles("TEST")
public class ReportCampaignNegativeKeywordsDefinitionTest
    extends AbstractReportDefinitionTest<ReportCampaignNegativeKeywords> {

  /**
   * C'tor
   */
  public ReportCampaignNegativeKeywordsDefinitionTest() {

    super(ReportCampaignNegativeKeywords.class,
        ReportDefinitionReportType.CAMPAIGN_NEGATIVE_KEYWORDS_PERFORMANCE_REPORT,
        "src/test/resources/csv/campaign-negative-keywords.csv");
  }

  /**
   * @see com.google.api.ads.adwords.awreporting.model.definitions.
   * AbstractReportDefinitionTest#testFirstEntry(
   * com.google.api.ads.adwords.awreporting.model.entities.Report)
   */
  @Override
  protected void testFirstEntry(ReportCampaignNegativeKeywords first) {

    Assert.assertEquals(11533780L, first.getKeywordId().longValue());
    Assert.assertEquals(116981433L, first.getCampaignId().longValue());
    Assert.assertEquals("Broad", first.getKeywordMatchType());
    Assert.assertEquals("gratuite", first.getCriteria());
    Assert.assertTrue(first.isNegative());

  }

  /**
   * @see com.google.api.ads.adwords.awreporting.model.definitions.
   * AbstractReportDefinitionTest#testLastEntry(
   * com.google.api.ads.adwords.awreporting.model.entities.Report)
   */
  @Override
  protected void testLastEntry(ReportCampaignNegativeKeywords last) {

    Assert.assertEquals(11679830L, last.getKeywordId().longValue());
    Assert.assertEquals(116996313L, last.getCampaignId().longValue());
    Assert.assertEquals("Broad", last.getKeywordMatchType());
    Assert.assertEquals("gratuit", last.getCriteria());
    Assert.assertTrue(last.isNegative());

  }

  /**
   * @see com.google.api.ads.adwords.awreporting.model.definitions.
   * AbstractReportDefinitionTest#retrieveCsvEntries()
   */
  @Override
  protected int retrieveCsvEntries() {

    return 8;
  }

  /**
   * @see com.google.api.ads.adwords.awreporting.model.definitions.
   * AbstractReportDefinitionTest#retrievePropertiesToBeSelected()
   */
  @Override
  protected String[] retrievePropertiesToBeSelected() {
    return new String[] {
        "CampaignId",
        "CampaignName",
        "CampaignStatus",
        "Id",
        "KeywordMatchType",
        "Criteria",
        "IsNegative"
    };
  }
}
