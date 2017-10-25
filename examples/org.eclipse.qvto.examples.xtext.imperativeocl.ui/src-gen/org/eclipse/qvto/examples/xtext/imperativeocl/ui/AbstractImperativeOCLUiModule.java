
/*
 * generated by Xtext
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Manual modifications go to {org.eclipse.qvto.examples.xtext.imperativeocl.ui.ImperativeOCLUiModule}
 */
@SuppressWarnings("all")
public abstract class AbstractImperativeOCLUiModule extends org.eclipse.xtext.ui.DefaultUiModule {

	public AbstractImperativeOCLUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}


	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public com.google.inject.Provider<org.eclipse.xtext.resource.containers.IAllContainersState> provideIAllContainersState() {
		return org.eclipse.xtext.ui.shared.Access.getJavaProjectsState();
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper> bindIProposalConflictHelper() {
		return org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public void configureHighlightingLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(org.eclipse.qvto.examples.xtext.imperativeocl.parser.antlr.internal.InternalImperativeOCLLexer.class);
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public void configureHighlightingTokenDefProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.ITokenDefProvider.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider.class);
	}

	// contributed by org.eclipse.xtext.generator.exporting.QualifiedNamesFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher> bindPrefixMatcher() {
		return org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher.class;
	}

	// contributed by org.eclipse.xtext.generator.exporting.QualifiedNamesFragment
	public Class<? extends org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator> bindIDependentElementsCalculator() {
		return org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator.class;
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public void configureIResourceDescriptionsBuilderScope(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE)).to(org.eclipse.xtext.builder.clustering.CurrentDescriptions.ResourceSetAware.class);
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public Class<? extends org.eclipse.xtext.generator.IContextualOutputConfigurationProvider> bindIContextualOutputConfigurationProvider() {
		return org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public void configureIResourceDescriptionsPersisted(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).annotatedWith(com.google.inject.name.Names.named("org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource.PERSISTED_DESCRIPTIONS")).to(org.eclipse.xtext.builder.builderState.IBuilderState.class);
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public Class<? extends org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource> bindDocumentBasedDirtyResource() {
		return org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
	public Class<? extends org.eclipse.jface.viewers.ILabelProvider> bindILabelProvider() {
		return org.eclipse.qvto.examples.xtext.imperativeocl.ui.labeling.ImperativeOCLLabelProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
	public void configureResourceUIServiceLabelProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class).annotatedWith(org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider.class).to(org.eclipse.qvto.examples.xtext.imperativeocl.ui.labeling.ImperativeOCLDescriptionLabelProvider.class);
	}

	// contributed by org.eclipse.xtext.ui.generator.outline.OutlineTreeProviderFragment
	public Class<? extends org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider> bindIOutlineTreeProvider() {
		return org.eclipse.qvto.examples.xtext.imperativeocl.ui.outline.ImperativeOCLOutlineTreeProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.outline.OutlineTreeProviderFragment
	public Class<? extends org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider> bindIOutlineTreeStructureProvider() {
		return org.eclipse.qvto.examples.xtext.imperativeocl.ui.outline.ImperativeOCLOutlineTreeProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.contentAssist.ContentAssistFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider> bindIContentProposalProvider() {
		return org.eclipse.qvto.examples.xtext.imperativeocl.ui.contentassist.ImperativeOCLProposalProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Factory> bindContentAssistContext$Factory() {
		return org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser> bindIContentAssistParser() {
		return org.eclipse.qvto.examples.xtext.imperativeocl.ui.contentassist.antlr.ImperativeOCLParser.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public void configureContentAssistLexerProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.qvto.examples.xtext.imperativeocl.ui.contentassist.antlr.internal.InternalImperativeOCLLexer.class).toProvider(org.eclipse.xtext.parser.antlr.LexerProvider.create(org.eclipse.qvto.examples.xtext.imperativeocl.ui.contentassist.antlr.internal.InternalImperativeOCLLexer.class));
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public void configureContentAssistLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST)).to(org.eclipse.qvto.examples.xtext.imperativeocl.ui.contentassist.antlr.internal.InternalImperativeOCLLexer.class);
	}

	// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
	public Class<? extends org.eclipse.xtext.ui.refactoring.IRenameStrategy> bindIRenameStrategy() {
		return org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
	public Class<? extends org.eclipse.xtext.ui.refactoring.IReferenceUpdater> bindIReferenceUpdater() {
		return org.eclipse.xtext.ui.refactoring.impl.DefaultReferenceUpdater.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
	public void configureIPreferenceStoreInitializer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer.class).annotatedWith(com.google.inject.name.Names.named("RefactoringPreferences")).to(org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences.Initializer.class);
	}

	// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
	public Class<? extends org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider> bindIRenameRefactoringProvider() {
		return org.eclipse.xtext.ui.refactoring.impl.DefaultRenameRefactoringProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
	public Class<? extends org.eclipse.xtext.ui.refactoring.ui.IRenameSupport.Factory> bindIRenameSupport$Factory() {
		return org.eclipse.xtext.ui.refactoring.ui.DefaultRenameSupport.Factory.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.quickfix.QuickfixProviderFragment
	public Class<? extends org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider> bindIssueResolutionProvider() {
		return org.eclipse.qvto.examples.xtext.imperativeocl.ui.quickfix.ImperativeOCLQuickfixProvider.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.EssentialOCLFragment
	public void configureString(com.google.inject.Binder binder) {
		binder.bind(String.class).annotatedWith(com.google.inject.name.Names.named((org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor.COMPLETION_AUTO_ACTIVATION_CHARS))).toInstance(".,:>");
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.EssentialOCLFragment
	public Class<? extends org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return org.eclipse.ocl.xtext.base.ui.syntaxcoloring.BaseAntlrTokenToAttributeIdMapper.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.EssentialOCLFragment
	public Class<? extends org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return org.eclipse.ocl.xtext.base.ui.autoedit.BaseAutoEditStrategyProvider.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.EssentialOCLFragment
	public Class<? extends org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return org.eclipse.ocl.xtext.essentialocl.ui.syntaxcoloring.EssentialOCLHighlightingConfiguration.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.EssentialOCLFragment
	public Class<? extends org.eclipse.xtext.resource.ILocationInFileProvider> bindILocationInFileProvider() {
		return org.eclipse.ocl.xtext.essentialocl.as2cs.EssentialOCLLocationInFileProvider.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.EssentialOCLFragment
	public Class<? extends org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return org.eclipse.ocl.xtext.essentialocl.ui.syntaxcoloring.EssentialOCLSemanticHighlightingCalculator.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.EssentialOCLFragment
	public Class<? extends org.eclipse.xtext.ui.editor.model.ITokenTypeToPartitionTypeMapper> bindITokenTypeToPartitionTypeMapper() {
		return org.eclipse.ocl.xtext.base.ui.model.BaseTerminalsTokenTypeToPartitionMapper.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.EssentialOCLFragment
	public Class<? extends org.eclipse.xtext.ui.editor.IURIEditorOpener> bindIURIEditorOpener() {
		return org.eclipse.ocl.xtext.base.ui.model.BaseURIEditorOpener.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.EssentialOCLFragment
	public Class<? extends org.eclipse.xtext.ui.editor.IXtextEditorCallback> bindIXtextEditorCallback() {
		return org.eclipse.xtext.ui.editor.validation.ValidatingEditorCallback.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.EssentialOCLFragment
	public Class<? extends org.eclipse.xtext.ui.editor.outline.actions.OutlineWithEditorLinker> bindOutlineWithEditorLinker() {
		return org.eclipse.ocl.xtext.base.ui.outline.BaseOutlineWithEditorLinker.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.EssentialOCLFragment
	public Class<? extends org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeElementOpener> bindOutlineNodeElementOpener() {
		return org.eclipse.ocl.xtext.base.ui.outline.BaseOutlineNodeElementOpener.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.EssentialOCLFragment
	public Class<? extends org.eclipse.xtext.ui.editor.model.XtextDocument> bindXtextDocument() {
		return org.eclipse.ocl.xtext.base.ui.model.BaseDocument.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.EssentialOCLFragment
	public Class<? extends org.eclipse.xtext.ui.editor.XtextEditor> bindXtextEditor() {
		return org.eclipse.qvto.examples.xtext.imperativeocl.ui.ImperativeOCLEditor.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.MarkupHoverFragment
	public Class<? extends org.eclipse.xtext.ui.editor.hover.IEObjectHover> bindIEObjectHover() {
		return org.eclipse.ocl.xtext.markup.ui.hover.MarkupHover.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.MarkupHoverFragment
	public Class<? extends org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return org.eclipse.ocl.xtext.markup.ui.hover.MarkupHoverProvider.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.MarkupHoverFragment
	public Class<? extends org.eclipse.xtext.documentation.IEObjectDocumentationProvider> bindIEObjectDocumentationProvider() {
		return org.eclipse.ocl.xtext.base.ui.model.BaseDocumentationProvider.class;
	}

	// contributed by org.eclipse.ocl.examples.build.fragments.MarkupHoverFragment
	public Class<? extends org.eclipse.jface.text.ITextHover> bindITextHover() {
		return org.eclipse.ocl.xtext.markup.ui.hover.MarkupCompositeHover.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public com.google.inject.Provider<org.eclipse.xtext.ui.codetemplates.ui.preferences.TemplatesLanguageConfiguration> provideTemplatesLanguageConfiguration() {
		return org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator.getTemplatesLanguageConfigurationProvider();
	}

	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public com.google.inject.Provider<org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry> provideLanguageRegistry() {
		return org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator.getLanguageRegistry();
	}

	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	@org.eclipse.xtext.service.SingletonBinding(eager=true)	public Class<? extends org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar> bindLanguageRegistrar() {
		return org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.templates.XtextTemplatePreferencePage> bindXtextTemplatePreferencePage() {
		return org.eclipse.xtext.ui.codetemplates.ui.preferences.AdvancedTemplatesPreferencePage.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.codetemplates.ui.partialEditing.IPartialContentAssistParser> bindIPartialContentAssistParser() {
		return org.eclipse.qvto.examples.xtext.imperativeocl.ui.contentassist.antlr.PartialImperativeOCLContentAssistParser.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.compare.CompareFragment
	public Class<? extends org.eclipse.compare.IViewerCreator> bindIViewerCreator() {
		return org.eclipse.xtext.ui.compare.DefaultViewerCreator.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.compare.CompareFragment
	public void configureCompareViewerTitle(com.google.inject.Binder binder) {
		binder.bind(String.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.UIBindings.COMPARE_VIEWER_TITLE)).toInstance("ImperativeOCL Compare");
	}


}
