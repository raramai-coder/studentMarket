from django.contrib import admin
from django.urls import path, include
from django.conf import settings
from django.conf.urls.static import static
from rest_framework import routers
from api import views

router = routers.DefaultRouter()
router.register(r'productCard', views.ProductCardViewSet)

router1 = routers.DefaultRouter()
router.register(r'order', views.OrderViewSet)

urlpatterns = [
    path('', include(router.urls)),
    path('', include(router1.urls))
]

urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)  # static are all files you use for styling
