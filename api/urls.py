from django.contrib import admin
from django.urls import path, include
from django.conf import settings
from django.conf.urls.static import static
from rest_framework import routers
from api import views

router = routers.DefaultRouter()

router.register(r'product', views.ProductViewSet)
router.register(r'order', views.OrderViewSet)
router.register(r'location', views.LocationViewSet)
router.register(r'category', views.CategoryViewSet)
router.register(r'user', views.UserViewSet)
router.register(r'saved', views.SavedViewSet)
router.register(r'store', views.StoreViewSet)
router.register(r'tier', views.TierViewSet)
router.register(r'review', views.ReviewViewSet)
router.register(r'cart', views.CartViewSet)
router.register(r'options', views.OptionsViewSet)
router.register(r'productCategory', views.ProductInCategoryViewSet)


urlpatterns = [
    path('', include(router.urls)),
]

urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)  # static are all files you use for styling
