import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class InterfaceQuestions extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
 <vaadin-vertical-layout id="vertical-titulo">
  <h1 id="titulo-form"></h1>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout id="horizontal-preguntas" style="margin-bottom: var(--lumo-space-m);">
  <vaadin-vertical-layout id="vertical-image-question" style="flex-grow: 1; align-self: center;"></vaadin-vertical-layout>
  <vaadin-vertical-layout></vaadin-vertical-layout>
  <vaadin-vertical-layout id="vertical-text-question" style="flex-grow: 5; align-self: center; justify-content: center; margin-left: var(--lumo-space-xl); text-align: justify"></vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout id="vertical-footer" style="margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs); margin-top: var(--lumo-space-xl); padding-top: var(--lumo-space-xs);">
  <vaadin-horizontal-layout id="horizontal-footer" style="margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs); margin-top: var(--lumo-space-xs); padding-top: var(--lumo-space-xs);">
   <vaadin-vertical-layout id="vertical-icons" style="align-self: stretch; margin-top: var(--lumo-space-l); padding-top: var(--lumo-space-l); margin-right: var(--lumo-space-xs); padding-right: var(--lumo-space-xs);">
    <vaadin-horizontal-layout id="horizontal-icon-mail" style="margin: var(--lumo-space-xs); padding: var(--lumo-space-xs); margin-right: var(--lumo-space-m); padding-right: var(--lumo-space-m);">
     <vaadin-horizontal-layout id="icono-mail" style="margin-right: var(--lumo-space-s); padding-right: var(--lumo-space-s);"></vaadin-horizontal-layout>madrid@hoodfinder.com 
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout id="horizontal-icon-phone" style="margin-right: var(--lumo-space-xs); padding-right: var(--lumo-space-xs);">
     <vaadin-horizontal-layout id="icono-phone" style="margin-right: var(--lumo-space-s); padding-right: var(--lumo-space-s);"></vaadin-horizontal-layout>+34 680 365 917 
    </vaadin-horizontal-layout>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout id="vertical-icons-2" style="margin-top: var(--lumo-space-l); padding-top: var(--lumo-space-l); margin-left: var(--lumo-space-s); padding-left: var(--lumo-space-s);">
    <vaadin-horizontal-layout id="horizontal-icon-database" style="margin: var(--lumo-space-xs); padding-left: var(--lumo-space-xl); padding-bottom: var(--lumo-space-m);"></vaadin-horizontal-layout>
    <vaadin-horizontal-layout id="horizontal-icon-recycle" style="margin-left: var(--lumo-space-xs); padding-left: var(--lumo-space-xs); margin: var(--lumo-space-xs); padding: var(--lumo-space-xs); padding-top: var(--lumo-space-xs); margin-top: var(--lumo-space-xs);"></vaadin-horizontal-layout>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout id="vertical-logo" style="margin-left: var(--lumo-space-xl); padding-left: var(--lumo-space-xl);"></vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'interface-questions';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(InterfaceQuestions.is, InterfaceQuestions);
