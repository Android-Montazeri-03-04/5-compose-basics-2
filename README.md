



![settings](https://github.com/user-attachments/assets/71b9fda3-de7e-4f7b-ac86-df867f7b5c59)




## ✨ هدف

ساخت صفحه تنظیمات مشابه تصویر زیر با استفاده از کامپوننت‌های Compose.

## 📱 کامپوننت اصلی

```kotlin
@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        TopAppBarContent()

        Spacer(modifier = Modifier.height(24.dp))

        val items = listOf(
            Icons.Default.AccountCircle to "Account",
            Icons.Default.Notifications to "Notification",
            Icons.Default.Tv to "Display",
            Icons.Default.Lock to "Privacy",
            Icons.Default.Payment to "Payment",
            Icons.Default.Language to "Language",
            Icons.Default.Security to "Security",
            Icons.Default.Info to "Help",
            Icons.Default.ExitToApp to "Logout"
        )

        items.forEach { (icon, title) ->
            SettingsItem(icon = icon, title = title)
        }
    }
}
```

---

## 📌 Top App Bar

```kotlin
@Composable
fun TopAppBarContent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Settings",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}
```

---

## ⚙️ آیتم‌های تنظیمات

```kotlin
@Composable
fun SettingsItem(icon: ImageVector, title: String) {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(context, "Clicked on $title", Toast.LENGTH_SHORT)
                    .show()
            }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(24.dp),
            tint = Color.DarkGray
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = title,
            modifier = Modifier.weight(1f),
            fontSize = 16.sp,
            color = Color.Black
        )

        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Go to $title",
            tint = Color.Gray
        )
    }
}
```

---

## 🧪 تمرین‌ها

1. یک آیتم جدید به نام `Security` به لیست اضافه کن با آیکون مناسب.
2. وقتی روی هر آیتم کلیک می‌کنی، یک `Toast` نمایش داده شود که اسم آیتم کلیک‌شده را نشان دهد.
3. رنگ متن‌ها و آیکون‌ها را مستقیماً تنظیم کن (مثلاً با `Color.Black`, `Color.Gray` و ...)

---

## ✅ پاسخ تمرینات

### تمرین 1: افزودن آیتم Security

```kotlin
Icons.Default.Security to "Security"
```

### تمرین 2: نمایش Toast

```kotlin
val context = LocalContext.current

.clickable {
    Toast.makeText(context, "Clicked on $title", Toast.LENGTH_SHORT).show()
}
```

### تمرین 3: تنظیم مستقیم رنگ‌ها

```kotlin
tint = Color.Black
color = Color.Gray
fontSize = 16.sp
fontWeight = FontWeight.Bold
```

---


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(context, "Clicked on $title", Toast.LENGTH_SHORT)
                    .show()
            }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colors.onSurface
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = title,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onSurface
        )

        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Go to $title",
            tint = MaterialTheme.colors.onSurface
        )
    }
}
```

---

## 🧪 تمرین‌ها

1. یک آیتم جدید به نام `Security` به لیست اضافه کن با آیکون مناسب.
2. وقتی روی هر آیتم کلیک می‌کنی، یک `Toast` نمایش داده شود که اسم آیتم کلیک‌شده را نشان دهد.
3. رنگ متن‌ها و آیکون‌ها را با استفاده از `MaterialTheme.colors.onSurface` به تم اصلی هماهنگ کن.

---

## ✅ پاسخ تمرینات

### تمرین 1: افزودن آیتم Security

```kotlin
val items = listOf(
    Icons.Default.AccountCircle to "Account",
    Icons.Default.Notifications to "Notification",
    Icons.Default.Tv to "Display",
    Icons.Default.Lock to "Privacy",
    Icons.Default.Payment to "Payment",
    Icons.Default.Language to "Language",
    Icons.Default.Security to "Security",
    Icons.Default.Info to "Help",
    Icons.Default.ExitToApp to "Logout"
)
```

### تمرین 2: نمایش Toast

```kotlin
val context = LocalContext.current

.clickable {
    Toast.makeText(context, "Clicked on $title", Toast.LENGTH_SHORT).show()
}
```

### تمرین 3: هماهنگ‌سازی رنگ‌ها

```kotlin
tint = MaterialTheme.colors.onSurface
color = MaterialTheme.colors.onSurface
```

---

### سورس کد کامل
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val items = listOf(
            Icons.Default.AccountCircle to "Account",
            Icons.Default.Notifications to "Notification",
            Icons.Default.Lock to "Privacy",
            Icons.Default.Info to "Help",
            Icons.Default.ExitToApp to "Logout"
        )
        setContent {
            val context = LocalContext.current
            MontazeriSession2Theme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp)
                ) {
                    Spacer(modifier = Modifier.height(12.dp))
                    TopAppBar()
                    Spacer(modifier = Modifier.height(12.dp))
                    items.forEach {
                        SettingItem(icon = it.first, title = it.second) {
                            Toast.makeText(context, it.second, Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(title = {
        Text(
            text = "Settings",
            fontSize = 24.sp,
            fontWeight = FontWeight.Black
        )
    }, navigationIcon = {
        Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = "back")
    }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent))
}

@Composable
fun SettingItem(icon: ImageVector, title: String, onItemClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(24.dp))
            .clickable { onItemClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = "")
        Spacer(modifier = Modifier.width(26.dp))
        Text(text = title)
        Spacer(modifier = Modifier.weight(1f))
        Icon(Icons.AutoMirrored.Default.KeyboardArrowRight, contentDescription = "")
    }
}
```
---

