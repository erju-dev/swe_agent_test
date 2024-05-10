import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class InterfaceFormulario extends PolymerElement {

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
 <h3 id="text-form" style="text-align: justify; margin-top: var(--lumo-space-s); padding-top: var(--lumo-space-s); padding-right: var(--lumo-space-l); padding-bottom: var(--lumo-space-s); margin-bottom: var(--lumo-space-s); padding-left: var(--lumo-space-l); margin-right: var(--lumo-space-l); margin-left: var(--lumo-space-l);"></h3>
 <vaadin-vertical-layout id="verticalForm">
  <vaadin-vertical-layout id="vertical-vecinos"></vaadin-vertical-layout>
  <vaadin-form-layout id="form-area" style="flex-grow: 1; margin-left: var(--lumo-space-m); padding-left: var(--lumo-space-m); margin-right: var(--lumo-space-m); padding-right: var(--lumo-space-m);"></vaadin-form-layout>
  <vaadin-vertical-layout id="vertical-presupuesto"></vaadin-vertical-layout>
  <vaadin-form-layout id="form-area2" style="flex-grow: 1; margin-left: var(--lumo-space-m); padding-left: var(--lumo-space-m); margin-right: var(--lumo-space-m); padding-right: var(--lumo-space-m);"></vaadin-form-layout>
  <vaadin-vertical-layout id="vertical-servicios"></vaadin-vertical-layout>
  <vaadin-form-layout id="form-area3" style="flex-grow: 1; margin-left: var(--lumo-space-m); padding-left: var(--lumo-space-m); margin-right: var(--lumo-space-m); padding-right: var(--lumo-space-m);"></vaadin-form-layout>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout id="vertical-clear" style="justify-content: center; align-self: center;"></vaadin-vertical-layout>
 <vaadin-vertical-layout id="vertical-grid" style="flex-grow: 1; align-self: center; margin-bottom: var(--lumo-space-m); padding-bottom: var(--lumo-space-m);"></vaadin-vertical-layout>
 <vaadin-vertical-layout id="vertical-transportes" style="padding-right: var(--lumo-space-xl); margin-right: var(--lumo-space-xl);">
  <vaadin-vertical-layout id="titulo-transporte" style="text-align: justify; margin-top: var(--lumo-space-s); padding-top: var(--lumo-space-s); padding-right: var(--lumo-space-xl); padding-bottom: var(--lumo-space-s); margin-bottom: var(--lumo-space-s); padding-left: var(--lumo-space-l); margin-right: var(--lumo-space-xl); margin-left: var(--lumo-space-l);"></vaadin-vertical-layout>
  <vaadin-horizontal-layout id="horizontal-text-transportes">
   <vaadin-vertical-layout id="metro-text"></vaadin-vertical-layout>
   <vaadin-vertical-layout id="cercanias-text"></vaadin-vertical-layout>
   <vaadin-vertical-layout id="bus-text"></vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout id="vertical-comments">
  <vaadin-vertical-layout id="comments" style="margin: var(--lumo-space-xs);"></vaadin-vertical-layout>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout id="vertical-print-comments" style="margin-bottom: var(--lumo-space-xl);"></vaadin-vertical-layout>
 <vaadin-vertical-layout id="vertical-footer" style="margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs); margin-top: var(--lumo-space-l); padding-top: var(--lumo-space-xs);">
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
        return 'interface-formulario';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(InterfaceFormulario.is, InterfaceFormulario);
