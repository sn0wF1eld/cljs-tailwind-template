(ns cljs-tailwind-template.core
  (:require [reagent.core :as r]
            [reagent.dom.client :as dom]))

(defonce app-state (r/atom {:text "Hello world!"}))

(defonce root (delay (dom/create-root (.getElementById js/document "app"))))

(defn app []
      [:div.bg-blue-500
       [:h1 (:text @app-state)]
       [:h3 "Edit this and watch it change!"]])

(defn ^:export ^:dev/after-load run []
      (dom/render @root [app]))

(defn ^:export init []
      ;; init is called ONCE when the page loads
      ;; this is called in the index.html and must be exported
      ;; so it is available even in :advanced release builds
      (run))

(defn stop []
      ;; stop is called before any code is reloaded
      ;; this is controlled by :before-load in the config
      (js/console.log "stop"))

