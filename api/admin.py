from django.contrib import admin
from api.models import User, Location, Category, Product, Saved, Store, Tier, Review, Order, Security, DropPin

# added this
# from api.models import Facilitator
#
# Register your models here.
# added this
# admin.site.register(Facilitator)

admin.site.register(User)
admin.site.register(Location)
admin.site.register(Category)
admin.site.register(Product)
admin.site.register(Saved)
admin.site.register(Store)
admin.site.register(Tier)
admin.site.register(Review)
admin.site.register(Order)
admin.site.register(Security)
admin.site.register(DropPin)



