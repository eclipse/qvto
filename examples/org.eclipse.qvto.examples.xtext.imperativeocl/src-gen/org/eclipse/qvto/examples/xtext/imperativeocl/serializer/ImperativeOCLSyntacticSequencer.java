/*
 * generated by Xtext
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.qvto.examples.xtext.imperativeocl.services.ImperativeOCLGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class ImperativeOCLSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ImperativeOCLGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ExpressionBlockCS_DoKeyword_1_q;
	protected AbstractElementAlias match_ExpressionStatementCS_SemicolonKeyword_1_q;
	protected AbstractElementAlias match_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q;
	protected AbstractElementAlias match_SwitchExpCS_EndifKeyword_0_4_q;
	protected AbstractElementAlias match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q;

	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ImperativeOCLGrammarAccess) access;
		match_ExpressionBlockCS_DoKeyword_1_q = new TokenAlias(false, true, grammarAccess.getExpressionBlockCSAccess().getDoKeyword_1());
		match_ExpressionStatementCS_SemicolonKeyword_1_q = new TokenAlias(false, true, grammarAccess.getExpressionStatementCSAccess().getSemicolonKeyword_1());
		match_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
		match_SwitchExpCS_EndifKeyword_0_4_q = new TokenAlias(false, true, grammarAccess.getSwitchExpCSAccess().getEndifKeyword_0_4());
		match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2()));
	}

	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}


	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_ExpressionBlockCS_DoKeyword_1_q.equals(syntax))
				emit_ExpressionBlockCS_DoKeyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ExpressionStatementCS_SemicolonKeyword_1_q.equals(syntax))
				emit_ExpressionStatementCS_SemicolonKeyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q.equals(syntax))
				emit_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SwitchExpCS_EndifKeyword_0_4_q.equals(syntax))
				emit_SwitchExpCS_EndifKeyword_0_4_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q.equals(syntax))
				emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     'do'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '{' '}' ';'? (rule start)
	 *     (rule start) (ambiguity) '{' '}' (rule start)
	 *     (rule start) (ambiguity) '{' ownedExps+=ExpressionStatementCS
	 */
	protected void emit_ExpressionBlockCS_DoKeyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) '*' (ambiguity) (rule start)
	 *     (rule start) 'Dict' '{' '}' (ambiguity) (rule start)
	 *     (rule start) 'List' '{' '}' (ambiguity) (rule start)
	 *     (rule start) 'break' (ambiguity) (rule start)
	 *     (rule start) 'continue' (ambiguity) (rule start)
	 *     (rule start) 'do'? '{' '}' (ambiguity) (rule start)
	 *     (rule start) 'invalid' (ambiguity) (rule start)
	 *     (rule start) 'null' (ambiguity) (rule start)
	 *     (rule start) 'return' (ambiguity) (rule start)
	 *     (rule start) 'self' (ambiguity) (rule start)
	 *     isPre?='@' 'pre' (ambiguity) (rule end)
	 *     ownedAltParts+=SwitchAltCS 'endif'? (ambiguity) (rule end)
	 *     ownedAltParts+=SwitchAltCS '}' (ambiguity) (rule end)
	 *     ownedArguments+=ExpCS ')' (ambiguity) (rule end)
	 *     ownedAssertion=ExpCS (ambiguity) (rule end)
	 *     ownedBody=ExpCS ')' (ambiguity) (rule end)
	 *     ownedBody=ExpCS (ambiguity) (rule end)
	 *     ownedCatchs+=CatchExpCS (ambiguity) (rule end)
	 *     ownedClassRef=TypeExpCS '(' ')' (ambiguity) (rule end)
	 *     ownedCondition=ExpCS ')' '{' '}' (ambiguity) (rule end)
	 *     ownedCondition=ExpCS ')' (ambiguity) (rule end)
	 *     ownedCondition=ExpCS (ambiguity) (rule end)
	 *     ownedCurlyBracketedClause=CurlyBracketedClauseCS (ambiguity) (rule end)
	 *     ownedDefault=ExpCS (ambiguity) (rule end)
	 *     ownedElement=ExpCS ')' (ambiguity) (rule end)
	 *     ownedElseExpression=ExpCS 'endif' (ambiguity) (rule end)
	 *     ownedElsePart=ExpCS 'endif'? (ambiguity) (rule end)
	 *     ownedElsePart=ExpCS '}' (ambiguity) (rule end)
	 *     ownedExpression=ExpCS ')' (ambiguity) (rule end)
	 *     ownedExpressionCS=ExpCS '}' (ambiguity) (rule end)
	 *     ownedExps+=ExpressionStatementCS '}' (ambiguity) (rule end)
	 *     ownedExtentRef=TypeNameExpCS '(' ')' (ambiguity) (rule end)
	 *     ownedInExpression=ExpCS (ambiguity) (rule end)
	 *     ownedLog=LogExpCS (ambiguity) (rule end)
	 *     ownedMessage=StringLiteralExpCS ')' (ambiguity) (rule end)
	 *     ownedParts+=CollectionLiteralPartCS '}' (ambiguity) (rule end)
	 *     ownedParts+=DictLiteralPartCS '}' (ambiguity) (rule end)
	 *     ownedParts+=MapLiteralPartCS '}' (ambiguity) (rule end)
	 *     ownedParts+=TupleLiteralPartCS '}' (ambiguity) (rule end)
	 *     ownedPathName=PathNameCS (ambiguity) (rule end)
	 *     ownedRight=ExpCS (ambiguity) (rule end)
	 *     ownedRight=PrefixedLetExpCS (ambiguity) (rule end)
	 *     ownedRight=PrefixedPrimaryExpCS (ambiguity) (rule end)
	 *     ownedRoundBracketedClause=RoundBracketedClauseCS (ambiguity) (rule end)
	 *     ownedSquareBracketedClauses+=SquareBracketedClauseCS (ambiguity) (rule end)
	 *     ownedType=CollectionTypeCS '{' '}' (ambiguity) (rule end)
	 *     ownedType=MapTypeCS '{' '}' (ambiguity) (rule end)
	 *     ownedType=TypeLiteralWithMultiplicityCS (ambiguity) (rule end)
	 *     ownedValue=ExpCS (ambiguity) (rule end)
	 *     ownedVarDeclarations+=VarDeclarationCS (ambiguity) (rule end)
	 *     segments+=StringLiteral (ambiguity) (rule end)
	 *     severity=SeverityKindCS ')' (ambiguity) (rule end)
	 *     symbol='false' (ambiguity) (rule end)
	 *     symbol='true' (ambiguity) (rule end)
	 *     symbol=NUMBER_LITERAL (ambiguity) (rule end)
	 */
	protected void emit_ExpressionStatementCS_SemicolonKeyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

	/**
	 * Ambiguous syntax:
	 *     '|?'?
	 *
	 * This ambiguous syntax occurs at:
	 *     lowerBound=LOWER (ambiguity) ']' (rule end)
	 *     stringBounds='*' (ambiguity) ']' (rule end)
	 *     stringBounds='+' (ambiguity) ']' (rule end)
	 *     stringBounds='?' (ambiguity) ']' (rule end)
	 *     upperBound=UPPER (ambiguity) ']' (rule end)
	 */
	protected void emit_MultiplicityCS_VerticalLineQuestionMarkKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

	/**
	 * Ambiguous syntax:
	 *     'endif'?
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedAltParts+=SwitchAltCS (ambiguity) ';'? (rule end)
	 *     ownedAltParts+=SwitchAltCS (ambiguity) (rule end)
	 *     ownedElsePart=ExpCS (ambiguity) ';'? (rule end)
	 *     ownedElsePart=ExpCS (ambiguity) (rule end)
	 */
	protected void emit_SwitchExpCS_EndifKeyword_0_4_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name='Tuple' (ambiguity) (rule end)
	 *     name='Tuple' (ambiguity) ownedMultiplicity=MultiplicityCS
	 */
	protected void emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}

}
