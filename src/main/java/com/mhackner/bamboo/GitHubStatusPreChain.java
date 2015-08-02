package com.mhackner.bamboo;

import com.atlassian.bamboo.chains.Chain;
import com.atlassian.bamboo.chains.ChainExecution;
import com.atlassian.bamboo.chains.plugins.PreChainAction;
import com.atlassian.bamboo.security.EncryptionService;
import com.atlassian.sal.api.ApplicationProperties;

import org.jetbrains.annotations.NotNull;
import org.kohsuke.github.GHCommitState;

public class GitHubStatusPreChain extends AbstractGitHubStatusAction implements PreChainAction {

    public GitHubStatusPreChain(ApplicationProperties applicationProperties,
                                EncryptionService encryptionService) {
        super(applicationProperties, encryptionService);
    }

    @Override
    public void execute(@NotNull Chain chain, @NotNull ChainExecution chainExecution) {
        updateStatus(GHCommitState.PENDING, chain, chainExecution);
    }

}
