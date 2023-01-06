(ns bodminroadrunners.layout
  (:require [hiccup.page :refer [html5]]
            [optimus.link :as link]))

(def navigation-items
  [{:title "Home", :path "/index.html"}
   {:title "About", :path "/about.html"}
   {:title "Training", :path "/training.html"}
   {:title "Join", :path "/join.html"}
   {:title "parkrun", :path "parkrun.html"}
   {:title "Social Hub", :path "socialmedia.html"}
   ])

(defn- nav-props [item path]
  (let [props {}]
    (if (= path (:path item))
      (assoc props :class "active")
      props)))

(defn- navigation [path]
  (map
   (fn [item]
     [:li (nav-props item path)
      [:a {:href (:path item)} (:title item )]
      ])
   navigation-items))

(defn- extra-javascript [javascript]
  (if (= javascript "carousels")
    [:script {:src "/assets/js/carousels.js"}]))


(defn layout-page-simple [request page]
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]
    [:title "Bodmin Road Runners"]
    [:link {:rel "stylesheet" :href (link/file-path request "/css/style.css")}]]
   [:body
    [:div.logo "Bodmin Road Runners"]
    [:div.body page]]))

(defn
  layout-page-main [request {:keys [title description javascript path content]}]
  (html5
   [:head
    
    [:meta {:charset "UTF-8"}] 
    [:meta {:name "viewport", :content "width=device-width, initial-scale=1"}] 
    [:meta {:name "viewport", :content "width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"}]
    [:title {} title] 
    [:link {:rel "shortcut icon", :href "/assets/img/favicon.png"}] 
    [:meta {:name "description", :content description}]
    [:link {:href "https://fonts.googleapis.com/css?family=Lato:100,300,400|Open+Sans:400italic,400,600|Muli:300|Indie+Flower:400|Oswald:400,700,300" :rel "stylesheet"}]
    [:link {:href "/assets/css/bootstrap.min.css", :rel "stylesheet"}]
    [:link {:href "/assets/css/bootstrap-switch.min.css", :rel "stylesheet"}]
    [:link {:href "/assets/css/font-awesome.min.css", :rel "stylesheet"}]
    [:link {:href "/assets/css/animate.min.css", :rel "stylesheet"}]
    [:link {:href "/assets/css/slidebars.min.css", :rel "stylesheet"}]
    ;; [:link {:href "/assets/css/lightbox.css", :rel "stylesheet"}]
    ;; [:link {:href "/assets/css/jquery.bxslider.css", :rel "stylesheet"}]
    [:link {:href "/assets/css/buttons.css", :rel "stylesheet"}]    
    [:link {:href "/assets/css/syntaxhighlighter/shCore.css", :rel "stylesheet"}]
    [:link {:href "/assets/css/style-blue.css", :rel "stylesheet", :title "default"}]
    [:link {:href "/assets/css/width-full.css", :rel "stylesheet", :title "default"}]
    [:link {:href "/assets/css/bodminroadrunners.css", :rel "stylesheet"}] 
    "<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->" "\n    " "<!--
[if lt IE 9]>\n        <script src=\"/assets/js/html5shiv.min.js\"></script>\n        <script src=\"/assets/js/respond.min.js\"></script>\n    <!
[endif]-->" "\n"]
   
   [:body {} 
    [:div {:id "sb-site"}
     [:div {:class "boxed"}
;;      [:header {:id "header-full-top", :class "hidden-xs header-full"} 
;;       [:div {:class "container"} 
;;        [:div {:class "header-full-title"} 
;;         [:h1 {:class "animated fadeInRight"} 
;;         [:a {:href "/index.html"} " "
;;   ]]]

;;    ]]

      [:nav {:class "navbar navbar-default navbar-header-full navbar-dark yamm navbar-static-top", :role "navigation", :id "header"}
       [:div {:class "container"}
        "<!-- Brand and toggle get grouped for better mobile display -->"
        [:div {:class "navbar-header"}
         [:button {:type "button", :class "navbar-toggle", :data-toggle "collapse", :data-target "#bs-example-navbar-collapse-1"} 
          [:span {:class "sr-only"} "Toggle navigation"] 
          [:i {:class "fa fa-bars"}]]
        [:a {:id "ar-brand", :class "navbar-brand hidden-lg hidden-md hidden-sm", :href "/index.html"} ]

    ]
     
        [:div {:class "collapse navbar-collapse", :id "bs-example-navbar-collapse-1"}
         [:ul {:class "nav navbar-nav"}

          (navigation path)]]]]
      
      content

      [:aside {:id "footer-widgets"}

           

        " " "<!-- row -->" ]
       " " "<!-- container -->" ]



     [:script {:src "/assets/js/vendors.js"}]


     [:script {:src "/assets/js/syntaxhighlighter/shCore.js"}]
     [:script {:src "/assets/js/syntaxhighlighter/shBrushXml.js"}]
     [:script {:src "/assets/js/syntaxhighlighter/shBrushJScript.js"}]
     "\n\n" [:script {:src "/assets/js/DropdownHover.js"}]
     [:script {:src "/assets/js/app.js"}]
     [:script {:src "/assets/js/holder.js"}]

     (extra-javascript javascript)]]))
